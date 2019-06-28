package com.mehmaa.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mehmaa.blog.domain.User;

/**
 * <p>
 * User repository
 * </p>
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
