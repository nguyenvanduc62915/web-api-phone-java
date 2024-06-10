package com.example.webapiphonejava.Repositories;

import com.example.webapiphonejava.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT cr FROM Customer cr WHERE cr.id = :customerId")
    Customer findCustomerById(@Param("customerId") Integer customerId);
}
