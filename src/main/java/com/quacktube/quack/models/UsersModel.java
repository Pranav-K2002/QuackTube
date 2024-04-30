package com.quacktube.quack.models;


import com.quacktube.quack.dto.RegisterDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;


import java.time.Instant;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
public class UsersModel {

    @Id
    String id;

    @Size(max = 50)
    @Indexed
    String username;

    @Email
    @Size(max = 100)
    String email;

    @Size(max = 100)
    @NotBlank
    String fullName;

    @Size(max = 100)
    @NotBlank
    String avatar;

    @NotBlank
    String coverImage;

    VideoModel[] watchHistory;

    @NotBlank
    String password;

    String refreshToken;

    Date createdAt;

    Date updatedAt;

    public UsersModel(RegisterDTO user) {
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.fullName = user.getFullName();
        this.coverImage = user.getCoverImage();
        this.password = user.getPassword();
        this.createdAt = Date.from(Instant.now());
    }

}

