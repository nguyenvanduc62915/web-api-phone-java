package com.example.webapiphonejava.Repositories;

import com.example.webapiphonejava.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.id =: userId")
    User findUserById(@Param("userId") Integer userId);
}
