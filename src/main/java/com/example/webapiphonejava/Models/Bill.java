package com.example.webapiphonejava.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "bills")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bill_id")
    private int id;
    @Column(name = "order_date")
    private LocalDate orderDate;
    @Column(name = "total_amount")
    private Double totalAmount;
    @Column(name = "receiving_address")
    @Size(max = 255, message = "Địa chỉ nhận hàng tối đa 255 ký tự!")
    private String receivingAddress;
    @Column(name = "note")
    @Size(max = 255, message = "Ghi chú tối đa 255 ký tự!")
    private String note;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", foreignKey = @ForeignKey(name = "FK_CUSTOMER_BILL"))
    private Customer customer;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "condition_id", foreignKey = @ForeignKey(name = "FK_CONDITION_BILL"))
    private Condition condition;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "shipper_id", foreignKey = @ForeignKey(name = "FK_SHIPPER_BILL"))
    private Shipper shipper;
    @OneToMany(mappedBy = "bill", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<BillDetails> billDetails;
}