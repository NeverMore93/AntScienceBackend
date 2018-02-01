package com.as.backend.antscience.controller;

import com.as.backend.antscience.dto.ArticleDto;
import com.as.backend.antscience.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:8102","*"}, maxAge = 3600)
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @GetMapping("/auth/articles")
    public List<ArticleDto> getArticles(){
        return articleService.getArticles();
    }

    @PostMapping("/article")
    public ArticleDto create(@RequestBody @Valid ArticleDto articleDto){
        return articleService.create(articleDto);
    }

    @PostMapping("/demoArticle")
    public ArticleDto demoArticle(){
        String[] label = {"demo"};
        List<String> content = new ArrayList<>();
        content.add("demo1");
        content.add("demo2");
        ArticleDto articleDto = new ArticleDto();
        articleDto.setAuthorName("yuan");
        articleDto.setLabel(label);
        articleDto.setTitle("Test");
        articleDto.setContent(content);
        return articleDto;
    }

    @GetMapping("/article/id/{id}")
    public  ArticleDto getById(@PathVariable Long id){
        return articleService.getById(id);
    }

    @DeleteMapping("/article/id/{id}")
    public void deleteById(@PathVariable Long id){
        articleService.deleteById(id);
    }

}
