package com.example.demobackend.user;


import com.example.demobackend.entry.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * The method checks if a specific username exists in the database
     *
     * @param username is the username of a User
     * @return the return value is a boolean
     */
    public boolean usernameExists(String username) {
        return userRepository.existsByUsernameIgnoreCase(username);
    }

    /**
     * The method registers a new User
     *
     * @param username is a username of the User
     * @param password is a plaintext password of the User
     * @return the return value is a newly saved User
     */
    public User register(String username, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        if (usernameExists(username)) {
            return null;
        } else {
            return userRepository.save(new User(username, encodedPassword));
        }
    }

    /**
     * The method is used for registering an admin and saving the object in the database
     *
     * @param username is a username of the admin
     * @param password is a plaintext password of the admin
     */
    public void registerAdmin(String username, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        User user = new User(username, encodedPassword);
        user.setAdmin(true);
        userRepository.save(user);
    }

    /**
     * The method is used for getting a User by the username from the database
     *
     * @param username is a username of the User
     * @return the return value is a User
     */
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).get();
    }

    /**
     * The method gets the User by the ID
     *
     * @param userId is the ID of the User
     * @return the return value is a User
     */
    public User getUserById(long userId) {
        return userRepository.findUserById(userId);
    }


}
