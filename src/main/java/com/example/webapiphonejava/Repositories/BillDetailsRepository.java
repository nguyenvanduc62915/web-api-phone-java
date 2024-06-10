package com.example.webapiphonejava.Repositories;

import com.example.webapiphonejava.Models.BillDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface BillDetailsRepository extends JpaRepository<BillDetails, Integer> {
    @Query("SELECT bd FROM BillDetails bd WHERE bd.id = :billDetailsId")
    BillDetails findBillDetailsById(@RequestParam("billDetailsId") Integer billDetailsId);
}
