package com.as.backend.antscience.controller;

import com.as.backend.antscience.entity.Comment;
import com.as.backend.antscience.service.CommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:8102","*"}, maxAge = 3600)
public class CommentController {

    @Resource(name = "commentService")
    private CommentService commentService;

    @PostMapping("/addComment")
    public Comment addComment(@RequestBody @Valid Comment comment ){

        return commentService.addComment(comment);
    }

    @PostMapping("/getCommentsByArticleId/{articleId}")
    public List<Comment> getCommentsByArticleId(@PathVariable("articleId") Long articleId){

        return commentService.getCommentsByArticleId(articleId);

    }

}
