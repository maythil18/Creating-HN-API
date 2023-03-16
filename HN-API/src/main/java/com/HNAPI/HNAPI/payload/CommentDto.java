package com.HNAPI.HNAPI.payload;

import java.util.List;

public class CommentDto {
    private Long id;
    private String text;
    private Long userId;
    private Long storyId;
    private List<CommentDto> childComments;
    private Long parentCommentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getStoryId() {
        return storyId;
    }

    public void setStoryId(Long storyId) {
        this.storyId = storyId;
    }

    public List<CommentDto> getChildComments() {
        return childComments;
    }

    public void setChildComments(List<CommentDto> childComments) {
        this.childComments = childComments;
    }

    public Long getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public CommentDto(Long id, String text, Long userId, Long storyId, List<CommentDto> childComments, Long parentCommentId) {
        this.id = id;
        this.text = text;
        this.userId = userId;
        this.storyId = storyId;
        this.childComments = childComments;
        this.parentCommentId = parentCommentId;
    }
}
