package com.as.backend.antscience.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "articles")
@ToString
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",unique=true)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "authorID")
    private Long authorID;

    @Column(name = "label")
    private String label;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "creationTime")
    private Date createTime;

    @Column(name = "likes")
    private Integer likes;
}
