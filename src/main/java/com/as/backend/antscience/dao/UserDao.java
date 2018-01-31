package com.as.backend.antscience.dao;

import com.as.backend.antscience.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface UserDao extends JpaRepository<User, Long> {
    User saveAndFlush(User user);

    User findUserByUsername(String username);

    @Query(value = "SELECT id FROM users WHERE username = ?1", nativeQuery = true)
    Long getUserIdByUsername(String username);

    @Query(value = "SELECT username FROM users WHERE id = ?1", nativeQuery = true)
    String getUsernameByUserId(Long id);

    User findUsersByUsernameOrEmailOrPhone(String username, String email, String phone);

    User findUserByPhone(String phone);



}
