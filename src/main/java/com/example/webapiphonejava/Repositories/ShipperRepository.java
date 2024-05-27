package com.example.webapiphonejava.Repositories;

import com.example.webapiphonejava.Models.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipperRepository extends JpaRepository<Shipper, Integer> {
    @Query("SELECT s FROM Shipper s WHERE s.id =: shipperId")
    Shipper findShipperById(@Param("shipperId") Integer shipperId);
}
