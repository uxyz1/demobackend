package com.example.demobackend.security;

import com.example.demobackend.user.User;
import com.example.demobackend.user.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SecurityController is a RestController of the User table, used for login purposes
 */
@RestController
public class SecurityController {

    private UserService userService;

    public SecurityController(UserService userService){
        this.userService = userService;
    }

    /**
     * The GetMapping method is used for returning a User according to the username and password in the UserDetails
     *
     * @param userDetails is a UserDetails object, consisting of a username and password
     * @return the return value is a User
     */

    @GetMapping("/api/sessionUser")
    public User sessionUser(@AuthenticationPrincipal UserDetails userDetails) {
        if (userDetails == null) {
            return null;
        }
        return userService.getUserByUsername(userDetails.getUsername());
    }
}
