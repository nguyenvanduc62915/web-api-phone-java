package com.example.webapiphonejava.Repositories;

import com.example.webapiphonejava.Models.Condition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionRepository extends JpaRepository<Condition, Integer> {
    @Query("SELECT cn FROM Condition cn WHERE cn.id =: conditionId")
    Condition findConditionId(@Param("conditionId") Integer conditionId);
}
