package com.example.springsecuritystarter.repository;

import com.example.springsecuritystarter.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    public User findUserByUserId(String userId);
}
