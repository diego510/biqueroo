package com.example.biquerito.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.example.biquerito.domain.Reaction;

@Repository
public interface ReactionRepository extends JpaRepository<Reaction, Long> {

    public List<Reaction> findByPublicationId(Long publicationId);
}
