package com.example.webapiphonejava.Repositories;

import com.example.webapiphonejava.Models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer> {
    @Query("SELECT b FROM Bill b WHERE b.id = :billId")
    Bill findBillById(@Param("billId") Integer billId);
}
