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
@Entity(name = "comments")
@ToString
@Table(name = "comments")
@Access(AccessType.FIELD)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",unique=true)
    private Long id;

    @Column(name = "articleId")
    private Long articleId;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "replyId")
    private Long replyId;

    @Column(name = "createTime")
    private Date createTime;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    private Boolean status;

}
