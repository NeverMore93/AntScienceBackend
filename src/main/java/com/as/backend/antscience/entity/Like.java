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
@Entity(name = "likes")
@ToString
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",unique=true)
    private Long id;

    @Column(name = "articleId")
    private Long articleId;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "createTime")
    private Date createTime;

    @Column(name = "isLike")
    private boolean isLike;

}
