package com.example.demoapplication.controllers;

import com.example.demoapplication.dto.user.ApiResponseDto;
import com.example.demoapplication.dto.user.LoginResponseDto;
import com.example.demoapplication.dto.user.SignInDto;
import com.example.demoapplication.dto.user.UserDto;
import com.example.demoapplication.exceptions.CustomException;
import com.example.demoapplication.model.User;
import com.example.demoapplication.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/signup")
    public ApiResponseDto signup(@RequestBody UserDto userDto) throws CustomException {
        logger.error(userDto.toString());
        try{
            return userService.signUp(userDto);
        }
        catch(CustomException ce){
            logger.error(ce.getMessage());
            return new ApiResponseDto("failed", "User already exists");
        }
    }

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody SignInDto signInDto) throws CustomException {
        try{
            return userService.login(signInDto);
        }
        catch(CustomException ce){
            logger.error(ce.getMessage());
            return new LoginResponseDto("failed", ce.getMessage(), null);
        }
    }

    @GetMapping("/all")
    public List<User> getAllUsers() throws CustomException {
        try {
            return userService.getAllUsers();
        } catch (CustomException e) {
            throw e;
        }
    }

    @GetMapping("/count")
    public Integer getUsersCount() throws CustomException {
        try {
            return userService.getUsersCount();
        } catch (CustomException e) {
            throw e;
        }
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable Integer id) throws CustomException {
        try {
            return userService.getUserById(id);
        } catch (CustomException e) {
            throw e;
        }
    }

    @GetMapping("/health")
    public String test() {
        return "Connection Success";
    }

}
