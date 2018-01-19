package com.as.backend.antscience.service;

import com.as.backend.antscience.dao.ArticleDao;
import com.as.backend.antscience.dao.UserDao;
import com.as.backend.antscience.dto.ArticleDto;
import com.as.backend.antscience.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service("articleServiceImpl")
public class ArticleServiceImpl implements ArticleService{
    @Resource
    private UserDao userDao;

    @Resource
    private ArticleDao articleDao;

    @Resource
    private UserService userService;

    @Override
    public ArticleDto createArticle(ArticleDto articleDto) {
        Article article=  ArticleDto2Article(articleDto);
        article = articleDao.saveAndFlush(article);
        articleDto = Article2ArticleDto(article,articleDto);
        saveArticle(articleDto.getContent(),article.getAuthorID(),article.getId());
        return articleDto;
    }

    @Override
    public List<ArticleDto> getAllArticles() {
        List<Article> articles = articleDao.findAll();
        List<ArticleDto> articleDtos = new ArrayList<>();
        for (Article article :  articles) {
            articleDtos.add(Article2ArticleDto(article,null));
        }

        return articleDtos;
    }

    @Override
    public ArticleDto getArticleById(Long userId, Long articleId) {
        File file = new File("/media/Acticles/"+userId+"/"+articleId+".txt");
        return null;
    }

    private ArticleDto Article2ArticleDto(Article article,ArticleDto articleDto){
        if(Objects.isNull(articleDto)){
            articleDto = new ArticleDto();
            articleDto.setTitle(article.getTitle());
            articleDto.setAuthorName(userDao.getUsernameByUserId(article.getId()));
            articleDto.setLabel(article.getLabel());
        }
        articleDto.setId(article.getId());
        articleDto.setCreateTime(article.getCreateTime());
        return articleDto;
    }

    private Article ArticleDto2Article(ArticleDto articleDto){
        Article article = new Article();
        article.setAuthorID(userDao.getUserIdByUsername(articleDto.getAuthorName()));
        article.setLabel(articleDto.getLabel());
        article.setTitle(articleDto.getTitle());
        return article;
    }

    private void saveArticle(String[] content,Long userId,Long articleId){
        File file = new File("/media/Acticles/"+userId+"/"+articleId+".txt");
        for(String str:content){
            try {
                FileUtils.writeStringToFile(file,str+"\n","UTF-8",false);
            } catch (IOException e) {
                log.info("存储文件"+userId+":"+articleId+"失败,存储路径:"+file.getPath());
                e.printStackTrace();
            }
        }
    }

    private String[] getArticleContent(Long id){

        return null;
    }
}
