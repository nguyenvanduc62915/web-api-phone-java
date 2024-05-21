package com.example.webapiphonejava.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bill_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillDetails extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_details_id")
    private int id;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private Double price;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "bill_id", foreignKey = @ForeignKey(name = "FK_BILL_BILLDETAILS"))
    private Bill bill;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "FK_PRODUCT_BILLDETAILS"))
    private Product product;
}

