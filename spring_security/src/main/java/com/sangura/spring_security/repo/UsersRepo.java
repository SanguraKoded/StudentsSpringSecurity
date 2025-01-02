package com.sangura.spring_security.repo;

import com.sangura.spring_security.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users, Integer> {
    Users findByUsername(String Username);
}
