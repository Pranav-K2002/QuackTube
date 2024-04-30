package com.quacktube.quack.controllers;

import com.quacktube.quack.constants.EndpointConstants;
import com.quacktube.quack.dto.LoginDTO;
import com.quacktube.quack.dto.RegisterDTO;
import com.quacktube.quack.models.UsersModel;
import com.quacktube.quack.services.RegisterUserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.quacktube.quack.repositories.UsersRepository;

@RestController
@RequestMapping(EndpointConstants.AUTH_BASE)
public class UserAuthController {

    private static final Logger logger = LoggerFactory.getLogger(UserAuthController.class);

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;
    private final RegisterUserService registerUserService;

    public UserAuthController(UsersRepository usersRepository, PasswordEncoder passwordEncoder, RegisterUserService registerUserService) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
        this.registerUserService = registerUserService;
    }

    @PostMapping(EndpointConstants.AUTH_REGISTER)
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterDTO user){
        try {
            UsersModel existingUsername = usersRepository.findByUsername(user.getUsername());
            UsersModel existingEmail = usersRepository.findByUsername(user.getEmail());

            if (existingUsername != null || existingEmail != null) {
                logger.warn("Username/Email '{}'/'{}' already exists", user.getUsername(),user.getEmail());
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Account already exists. Please try again!");
            }
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            RegisterDTO userSave = registerUserService.save(user);

            if(userSave != null) {
                logger.info("User '{}' successfully registered", user.getUsername());
                return ResponseEntity.status(HttpStatus.CREATED).body("User successfully created!");
            } else {
                logger.error("Failed to register user '{}'", user.getUsername());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register user. Please try again later.");
            }
        } catch (Exception e) {
            logger.error("Error while registering user", e);
            return ResponseEntity.internalServerError().body("An error occurred while processing your request. Please try again later.");
        }
    }

    @PostMapping(EndpointConstants.AUTH_LOGIN)
    public ResponseEntity<?> login(@RequestBody LoginDTO user) {
        try {
            UsersModel existingEmail = usersRepository.findByEmail(user.getEmail());
            if (existingEmail == null ) {
                logger.warn("Email '{}' doesn't exist", user.getEmail());
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Account doesn't exist. Please register first!");
            }
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return ResponseEntity.status(HttpStatus.CREATED).body("User successfully created!");
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
