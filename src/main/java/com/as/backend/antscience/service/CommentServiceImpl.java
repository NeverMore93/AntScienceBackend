package com.as.backend.antscience.service;

import com.as.backend.antscience.dao.CommentDao;
import com.as.backend.antscience.entity.Comment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentDao commentDao;

    @Override
    public Comment addComment(Comment comment) {
        return commentDao.saveAndFlush(comment);
    }

    @Override
    public List<Comment> getCommentsByArticleId(Long articleId) {
        return commentDao.findCommentsByArticleId(articleId);
    }
}
