package com.spring.jwt.service;

import com.spring.jwt.auth.UserPrincipal;
import com.spring.jwt.entity.User;

public interface UserService {
	User createUser(User user);
	UserPrincipal findByUsername(String username);
}
