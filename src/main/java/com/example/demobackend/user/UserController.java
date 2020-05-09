package com.example.demobackend.user;


import com.example.demobackend.security.RegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * The PostMapping method is used for registering a user, according to the RegistrationDTO object
     *
     * @param registrationDTO is a RegistrationDTO object, passed as a RequestBody
     * @return the return value is a User
     */
    @PostMapping("/api/register")
    public User register(@RequestBody RegistrationDTO registrationDTO) {
        return userService.register(registrationDTO.getUsername(), registrationDTO.getPassword1());
    }

}
