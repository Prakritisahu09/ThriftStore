package com.example.demoapplication.service;

import com.example.demoapplication.dto.user.ApiResponseDto;
import com.example.demoapplication.dto.user.LoginResponseDto;
import com.example.demoapplication.dto.user.SignInDto;
import com.example.demoapplication.dto.user.UserDto;
import com.example.demoapplication.exceptions.CustomException;
import com.example.demoapplication.model.User;
import com.example.demoapplication.repository.UserRepository;
import com.example.demoapplication.utils.Helper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.xml.bind.DatatypeConverter;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(UserService.class);

    public ApiResponseDto signUp(UserDto userDto)  throws CustomException {
        // Check to see if the current email address has already been registered.
        if (Objects.nonNull(userRepository.findByEmail(userDto.getEmail()))) {
            // If the email address has been registered then throw an exception.
            throw new CustomException("User already exists");
        }
        // first encrypt the password
        String encryptedPassword = userDto.getPassword();
        try {
            encryptedPassword = hashPassword(userDto.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error("hashing password failed {}", e.getMessage());
        }


        User user = new User(userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(), encryptedPassword, userDto.getAddress(),userDto.getPhNumber(), userDto.getPincode() );
        try {
            // save the User
            userRepository.save(user);
            logger.info("User " + user.getFirstName() + " created successfully");
            // success in creating
            return new ApiResponseDto("success", "user created successfully");
        } catch (Exception e) {
            // handle signup error
            throw new CustomException(e.getMessage());
        }
    }



    public LoginResponseDto login(SignInDto signInDto) throws CustomException {
        // first find User by email
        User user = userRepository.findByEmail(signInDto.getEmail());
        if(!Helper.notNull(user)){
            throw new CustomException("user not present");
        }
        try {
            // check if password is right
            if (!user.getPassword().equals(hashPassword(signInDto.getPassword()))){
                // password does not match
                throw new CustomException("Wrong Password");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            logger.error("hashing password failed {}", e.getMessage());
            throw new CustomException("hashing password failed");
        }

//        if (!user.getPassword().equals(signInDto.getPassword())){
//            // password does not match
//            throw new CustomException("Wrong Password");
//        }
        logger.info(user.getFirstName() + " login successful");
        return new LoginResponseDto("success", "Login Successful", user.getFirstName());
    }


    public List<User> getAllUsers() throws CustomException {
        try{
            return userRepository.findAll();
        }
        catch (Exception e){
            throw new CustomException("Failed to find users");
        }
    }

    public Integer getUsersCount() throws CustomException {
        try{
            return userRepository.findAll().size();
        }
        catch (Exception e){
            throw new CustomException("Failed to find users");
        }
    }

    public Optional<User> getUserById(Integer id) throws CustomException{
        try{
            return userRepository.findById(id);
        }
        catch (Exception e){
            throw new CustomException("Failed to find user that you are looking for");
        }
    }


    String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
        return myHash;
    }

}
