package com.example.webapiphonejava.Repositories;

import com.example.webapiphonejava.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("SELECT o FROM Order o WHERE o.id = :orderId")
    Order findOrderById(@Param("orderId") Integer orderId);
}
