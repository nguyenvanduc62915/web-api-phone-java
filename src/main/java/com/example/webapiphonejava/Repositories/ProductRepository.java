package com.example.webapiphonejava.Repositories;

import com.example.webapiphonejava.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE p.id =: productId")
    Product findProductById(@Param("productId") Integer productId);
}
