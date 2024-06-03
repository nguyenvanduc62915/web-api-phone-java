package com.example.webapiphonejava.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "conditions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Condition extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "condition_id")
    private int id;
    @Column(name = "order_status")
    @Size(max = 255, message = "Tình trạng đơn hàng tối ta 255 ký tự!")
    private String orderStatus;
    @OneToMany(mappedBy = "condition", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonInclude
    private List<Bill> bills;
}
