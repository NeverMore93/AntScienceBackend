package com.as.backend.antscience.dto;

import com.as.backend.antscience.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    @Email
    private String email;
    @Pattern(regexp = "^1\\d{10}$")
    private String phone;
    private Gender gender;
    private String token;
}
