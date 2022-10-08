package com.spring.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.jwt.entity.Token;

public interface TokenRepository
        extends JpaRepository<Token, Long> {
    Token findByToken(String token);
}
