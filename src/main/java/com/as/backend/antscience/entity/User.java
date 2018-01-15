package com.as.backend.antscience.entity;

import com.as.backend.antscience.enums.Gender;
import lombok.*;
import org.apache.commons.lang3.ArrayUtils;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import javax.persistence.Entity;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
@ToString
@Table(name = "users")
@Access(AccessType.FIELD)
public class User implements UserDetails{
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

    public Set<SimpleGrantedAuthority> getAuthorities(){
        Set<SimpleGrantedAuthority> simpleGrantedAuthoritySet = new HashSet<>();
        for (String authority:roles) {
            simpleGrantedAuthoritySet.add(new SimpleGrantedAuthority(authority));
        }
        return simpleGrantedAuthoritySet;
    }

    public void addAuthorities(String authority) {
        roles = ArrayUtils.add( roles, authority );
    }

}
