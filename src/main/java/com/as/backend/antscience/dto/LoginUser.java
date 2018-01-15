package com.as.backend.antscience.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

@Data
public class LoginUser {
    @NotBlank
    private String identity;
    @NotBlank
    private String password;
}
