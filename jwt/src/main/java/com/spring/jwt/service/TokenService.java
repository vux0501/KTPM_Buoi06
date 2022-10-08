package com.spring.jwt.service;

import com.spring.jwt.entity.Token;

public interface TokenService {
    Token createToken(Token token);

    Token findByToken(String token);
    
}
