package com.example.biquerito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.biquerito.domain.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

}
