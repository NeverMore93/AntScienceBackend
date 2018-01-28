package com.as.backend.antscience.entity;

import com.as.backend.antscience.enums.Gender;
import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
@ToString
@Table(name = "users")
@Access(AccessType.FIELD)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",unique=true)
    private Long id;

    @NotBlank
    @Column(name = "password")
    private String password;

    @NotBlank
    @Column(name = "username")
    private String username;

    @Email
    @Column(name = "email")
    private String email;


    @Column(name = "phone")
    @Pattern(regexp = "^1\\d{10}$")
    private String phone;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "authorities")
    private String[] roles = {"general"};

    @Column(name = "accountNonExpired")
    private boolean accountNonExpired;

    @Column(name = "accountNonLocked")
    private boolean accountNonLocked;

    @Column(name = "credentialsNonExpired")
    private boolean credentialsNonExpired;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "creationTime")
    private Timestamp createTime;

}
