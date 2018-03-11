package com.as.backend.antscience.service;

import com.as.backend.antscience.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment addComment(Comment comment);
    List<Comment> getCommentsByArticleId(Long articleId);
}
