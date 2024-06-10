package com.example.webapiphonejava.Repositories;

import com.example.webapiphonejava.Models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query("SELECT ct FROM Comment ct WHERE ct.id = :commentId")
    Comment findCommentById(@Param("commentId") Integer commentId);
}
