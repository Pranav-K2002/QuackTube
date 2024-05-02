package com.quacktube.quack.models;

import com.quacktube.quack.enums.VideoStatusEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "videos")
public class VideoModel {
    @Id
    private String id;

    private String title;

    private String description;

    private String userId;

    private Integer likes = 0;

    private Integer disLikes = 0;

    private List<String> tags;

    private Date uploadDate;

    private String url;

    private VideoStatusEnum videoStatus;

    private Integer viewCount = 0;

    private String thumbnailUrl;

    private List<CommentsModel> comments = new ArrayList<>();
}
