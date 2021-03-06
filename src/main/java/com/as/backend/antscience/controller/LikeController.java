package com.as.backend.antscience.controller;

import com.as.backend.antscience.dto.LikeDto;
import com.as.backend.antscience.service.LikeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by lirui on 2018/2/2.
 */
@RestController
@CrossOrigin(origins = {"http://localhost:8102","*"}, maxAge = 3600)

public class LikeController {

    @Resource
    private LikeService likeService;

    @ApiOperation("点赞/取消点赞")
    @PostMapping("/like")
    public LikeDto create(@RequestBody @Valid LikeDto likeDto){
        return likeService.create(likeDto);
    }
}
