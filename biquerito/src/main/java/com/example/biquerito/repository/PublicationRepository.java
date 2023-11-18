package com.example.biquerito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.example.biquerito.domain.Publication;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {

    public List<Publication> findByUserId(Long userId);
}
