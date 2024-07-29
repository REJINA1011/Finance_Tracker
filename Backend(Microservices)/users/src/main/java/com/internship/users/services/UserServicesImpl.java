package com.internship.users.services;

import com.internship.users.dto.UserDTO;
import com.internship.users.entity.DataResponse;
import com.internship.users.entity.User;
import com.internship.users.exception.EmailAlreadyInUse;

import com.internship.users.exception.UserNotFoundException;
import com.internship.users.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpl {
    @Autowired
    UserRepository userRepository;

    private DataResponse dataResponse= new DataResponse();

    public void addNewUser(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new EmailAlreadyInUse("Email is already in use");
        }
        userRepository.save(user);
    }

    public String loginUser(UserDTO oldUser, HttpSession session) {
        User userInformation=userRepository.getUser(oldUser.getEmail(),oldUser.getPassword());

        if(userInformation==null){
            throw new UserNotFoundException("User with the given credentials not found");
        }
        session.setAttribute("email",userInformation.getEmail());
        return "success";
    }

    public Long getUserId(String email) {
        Long userId = userRepository.getUserId(email);
        if (userId == null) {
            throw new UserNotFoundException("User Not Found");
        }
        return userId;
    }
}
