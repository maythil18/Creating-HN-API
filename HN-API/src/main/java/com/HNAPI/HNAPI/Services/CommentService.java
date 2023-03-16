package com.HNAPI.HNAPI.Services;

import com.HNAPI.HNAPI.payload.CommentDto;

import java.util.List;

public interface CommentService {
    List<CommentDto> getAllComments();
    CommentDto getCommentById(Long id);
    CommentDto createComment(CommentDto commentDto);
    CommentDto updateComment(Long id, CommentDto commentDto);
    void deleteCommentById(Long id);
}