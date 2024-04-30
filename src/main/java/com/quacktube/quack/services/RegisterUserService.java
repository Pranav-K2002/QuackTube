package com.quacktube.quack.services;

import com.quacktube.quack.dto.RegisterDTO;
import org.springframework.stereotype.Service;

@Service
public interface RegisterUserService {
    RegisterDTO save(RegisterDTO user);
}
