package com.example.webapiphonejava.Models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {
    @Column(name = "create_at")
    private LocalDate createAt;
    @Column(name = "update_at")
    private LocalDate updateAt;
    @PrePersist
    public void createAt(){
        this.createAt = LocalDate.now();
    }
    @PreUpdate
    public void updateAt(){
        this.updateAt = LocalDate.now();
    }
}