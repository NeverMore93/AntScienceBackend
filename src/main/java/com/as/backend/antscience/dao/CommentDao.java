package com.as.backend.antscience.dao;

import com.as.backend.antscience.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface CommentDao extends JpaRepository<Comment, Long> {
    Comment saveAndFlush(Comment comment);
    List<Comment> findCommentsByArticleId(Long articleId);
    Comment findOne(Long id);
}
