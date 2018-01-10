package com.as.backend.antscience.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Data
@Entity(name = "authorities")
@Embeddable
@Table(name = "authorities", uniqueConstraints={@UniqueConstraint(columnNames={"authority","username"})})
class SimpleGrantedAuthority implements GrantedAuthority {
    private Long id;
    @Column(name = "authority")
    private String authority;
    @Column(name = "username")
    private String username;
}
