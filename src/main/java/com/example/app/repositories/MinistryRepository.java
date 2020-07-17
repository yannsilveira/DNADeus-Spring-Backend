package com.example.app.repositories;

import com.example.app.domain.Ministry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MinistryRepository extends JpaRepository<Ministry, Integer> {
}
