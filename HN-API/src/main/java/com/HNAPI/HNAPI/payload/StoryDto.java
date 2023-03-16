package com.HNAPI.HNAPI.payload;

import java.time.LocalDateTime;
import java.util.List;

public class StoryDto {
    private Long id;
    private String title;
    private String url;
    private int score;
    private LocalDateTime timeOfSubmission;
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public LocalDateTime getTimeOfSubmission() {
        return timeOfSubmission;
    }

    public void setTimeOfSubmission(LocalDateTime timeOfSubmission) {
        this.timeOfSubmission = timeOfSubmission;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }

    public StoryDto(Long id, String title, String url, int score, LocalDateTime timeOfSubmission, Long userId, List<CommentDto> comments) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.score = score;
        this.timeOfSubmission = timeOfSubmission;
        this.userId = userId;
        this.comments = comments;
    }

    private List<CommentDto> comments;

}