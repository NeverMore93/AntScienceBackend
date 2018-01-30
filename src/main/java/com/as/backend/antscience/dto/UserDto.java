package com.as.backend.antscience.dto;

import com.as.backend.antscience.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private String phone;
    private Gender gender;
    private String token;
}
