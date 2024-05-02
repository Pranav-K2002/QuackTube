package com.quacktube.quack.services;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    public String uploadFile(MultipartFile file);
}
