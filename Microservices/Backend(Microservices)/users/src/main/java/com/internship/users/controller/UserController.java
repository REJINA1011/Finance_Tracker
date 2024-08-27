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
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    @Autowired
    private UserServicesImpl userServices;

//    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/register")
    private void addNewUser( @RequestBody User user){
        userServices.addNewUser(user);
    }
//    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    private void userLogin(@RequestBody UserDTO oldUser, HttpSession session){
       userServices.loginUser(oldUser, session);
    }
//    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getUserId")
    private Long getUserId(HttpSession session){
        String email = (String) session.getAttribute("email");
        if (email == null) {

         throw new UserNotFoundException("User with that email not found");
        }
        return userServices.getUserId(email);
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getUserData/{email}")
    private ResponseEntity<DataResponse> getUserData(@PathVariable("email") String email){
        DataResponse dataResponse = this.userServices.getUserByEmail(email);
        return new ResponseEntity<>(dataResponse,HttpStatus.OK);
    }
}
