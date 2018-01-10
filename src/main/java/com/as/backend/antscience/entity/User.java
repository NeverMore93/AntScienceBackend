package com.as.backend.antscience.entity;

import com.as.backend.antscience.enums.Gender;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Set;
import org.hibernate.annotations.CascadeType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
@ToString
@Table(name = "users")
@Embeddable
public class User implements UserDetails, CredentialsContainer {
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
//    @JoinTable(name = "users_authorities",joinColumns = @JoinColumn( name="users_id"),inverseJoinColumns = {@JoinColumn(name = "authorities_authority",referencedColumnName ="authority"),@JoinColumn(name ="authorities_username",referencedColumnName ="username")})
    @OneToMany
    @Cascade({CascadeType.ALL })
    @JoinTable(name = "users_authorities")
    private Set<SimpleGrantedAuthority> authorities;
    @Column(name = "accountNonExpired")
    private boolean accountNonExpired;
    @Column(name = "accountNonLocked")
    private boolean accountNonLocked;
    @Column(name = "credentialsNonExpired")
    private boolean credentialsNonExpired;
    @Column(name = "enabled")
    private boolean enabled;
    @Override
    public void eraseCredentials() {
        password = null;
    }
}
