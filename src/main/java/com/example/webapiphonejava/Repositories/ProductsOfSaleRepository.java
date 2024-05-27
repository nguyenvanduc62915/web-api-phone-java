package com.example.webapiphonejava.Repositories;

import com.example.webapiphonejava.Models.ProductsOfSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsOfSaleRepository extends JpaRepository<ProductsOfSale, Integer> {
    @Query("SELECT pe FROM ProductsOfSale pe WHERE pe.id =: productsOfSaleId")
    ProductsOfSale findProductsOfSaleById(@Param("productsOfSaleId") Integer productsOfSaleId);
}
