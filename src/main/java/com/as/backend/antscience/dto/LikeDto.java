package com.as.backend.antscience.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by lirui on 2018/2/2.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LikeDto {

    private Long id;
    private Long articleId;
    private Long userId;

}
