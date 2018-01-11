package com.as.backend.antscience.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Data
@Entity(name = "authorities")
@Table(name = "authorities")
class SimpleGrantedAuthority implements GrantedAuthority {
    @Column(name = "authority",unique=true)
    @Id
    private String authority;
}
