package com.example.biquerito.repository;

import org.springframework.stereotype.Repository;

import com.example.biquerito.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
