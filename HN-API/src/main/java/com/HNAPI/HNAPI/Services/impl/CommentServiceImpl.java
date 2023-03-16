package com.HNAPI.HNAPI.Services.impl;

import com.HNAPI.HNAPI.Services.CommentService;
import com.HNAPI.HNAPI.payload.CommentDto;
import com.HNAPI.HNAPI.repository.CommentRepository;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;
    private ModelMapper modelMapper;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CommentDto> getAllComments() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream()
                .map(comment -> modelMapper.map(comment, CommentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.map(value -> modelMapper.map(value, CommentDto.class)).orElse(null);
    }

    @Override
    public CommentDto createComment(CommentDto commentDto) {
        Comment comment = modelMapper.map(commentDto, Comment.class);
        Comment savedComment = commentRepository.save(comment);
        return modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public CommentDto updateComment(Long id, CommentDto commentDto) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if (optionalComment.isPresent()) {
            Comment comment = optionalComment.get();
            modelMapper.map(commentDto, comment);
            comment.setId(id);
            Comment updatedComment = commentRepository.save(comment);
            return modelMapper.map(updatedComment, CommentDto.class);
        } else {
            return null;
        }
    }

    @Override
    public void deleteCommentById(Long id) {

        commentRepository.deleteById(id);
    }
}