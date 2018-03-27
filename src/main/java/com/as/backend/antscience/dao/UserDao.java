package com.as.backend.antscience.dao;

import com.as.backend.antscience.entity.User;
import com.as.backend.antscience.enums.Gender;
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

    @Query(value = "SELECT * FROM users WHERE phone = ?1 OR email = ?1 OR username = ?1", nativeQuery = true)
    User findIdentity(String identity);

    @Query(value = "SELECT * FROM users WHERE phone = ?1", nativeQuery = true)
    User findUserByPhone(String phone);

    @Query(value="update users set username=?2, email=?3,phone=?4,gender=?5 where id=?1")
    User resetUserProperties(Long id, String username, String email, String phone, Gender gender);

}
