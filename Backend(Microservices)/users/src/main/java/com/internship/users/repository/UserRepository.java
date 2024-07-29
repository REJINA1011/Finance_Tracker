package com.internship.users.repository;

import com.internship.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT user.id FROM User user WHERE user.email=:email")
    Long getUserId(String email);

    Optional<User> findByEmail(String email);

    @Query("SELECT user FROM User user WHERE user.email=:email AND user.password=:password")
    User getUser(String email, String password);
}
