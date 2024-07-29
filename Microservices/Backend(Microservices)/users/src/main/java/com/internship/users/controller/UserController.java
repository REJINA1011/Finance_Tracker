package com.internship.users.controller;

import com.internship.users.dto.UserDTO;
import com.internship.users.entity.DataResponse;
import com.internship.users.entity.User;
import com.internship.users.exception.UserNotFoundException;
import com.internship.users.services.UserServicesImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserServicesImpl userServices;

    @PostMapping("/register")
    private void addNewUser( @RequestBody User user){
        userServices.addNewUser(user);
    }

    @GetMapping("/login")
    private String userLogin(@RequestBody UserDTO oldUser, HttpSession session){
         String value=userServices.loginUser(oldUser, session);
         return value;
    }

    @GetMapping("/getUserId")
    private Long getUserId(HttpSession session){
        String email = (String) session.getAttribute("email");
        if (email == null) {

         throw new UserNotFoundException("User with that email not found");
        }
        return userServices.getUserId(email);
    }
}
