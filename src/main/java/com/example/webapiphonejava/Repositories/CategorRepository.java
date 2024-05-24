package com.example.webapiphonejava.Repositories;

import com.example.webapiphonejava.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorRepository extends JpaRepository<Category, Integer> {
    @Query("SELECT c FROM Category c WHERE c.id =: categoryId")
    Category findCategoryById(@Param("categoryId") Integer categoryId);
}
