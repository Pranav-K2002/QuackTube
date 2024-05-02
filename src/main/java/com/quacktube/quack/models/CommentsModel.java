package com.quacktube.quack.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentsModel {
    @Id
    private String id;

    private String text;

    private String author;

    private Integer likes = 0;

    private Integer disLikes = 0;
}
