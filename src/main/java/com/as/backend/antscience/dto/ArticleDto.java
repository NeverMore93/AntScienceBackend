package com.as.backend.antscience.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {
    private Long id;
    private String title;
    private String authorName;
    private String[] label;
    private String[] content;
    private Timestamp createTime;
}
