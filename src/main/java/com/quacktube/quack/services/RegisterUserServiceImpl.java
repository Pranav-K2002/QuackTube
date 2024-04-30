package com.quacktube.quack.services;

import com.quacktube.quack.controllers.UserAuthController;
import com.quacktube.quack.dto.RegisterDTO;
import com.quacktube.quack.models.UsersModel;
import com.quacktube.quack.repositories.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class RegisterUserServiceImpl implements RegisterUserService {

    private static final Logger logger = LoggerFactory.getLogger(RegisterUserServiceImpl.class);

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterUserServiceImpl(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public RegisterDTO save(RegisterDTO user){
        try {
            UsersModel userModel = new UsersModel();
            userModel.setUsername(user.getUsername());
            userModel.setPassword(passwordEncoder.encode(user.getPassword()));
            userModel.setEmail(user.getEmail());
            userModel.setFullName(user.getFullName());
            userModel.setCoverImage(user.getCoverImage());
            userModel.setCreatedAt(Date.from(Instant.now()));

            usersRepository.save(userModel);
            logger.info("User registered successfully: {}", user.getUsername());
            return user;
        }catch(Exception e){
            logger.error("Error occurred while registering user: {}", user.getUsername(), e);
            return null;
        }
    }

}
