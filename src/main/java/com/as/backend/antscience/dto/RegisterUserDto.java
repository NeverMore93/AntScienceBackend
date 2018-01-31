package com.as.backend.antscience.dto;

import com.as.backend.antscience.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDto {
    private String username;
    @Email
    private String email;
    @Pattern(regexp = "^1\\d{10}$")
    private String phone;
    private Gender gender;
    private String password;
}
