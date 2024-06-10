package com.example.webapiphonejava.Repositories;

import com.example.webapiphonejava.Models.SeedData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeeđDataRepository extends JpaRepository<SeedData, Long> {
}
