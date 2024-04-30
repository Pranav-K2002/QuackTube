package com.quacktube.quack.models;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NotNull
@Document(collection = "users")
public class VideoModel {
    @Id
    String id;
    String videoFile;
    String thumbnail;
    String title;
    String description;
    Integer duration;
    Integer views;
    Boolean isPublished;
    UsersModel owner;
    Date uploadedDate;
}
