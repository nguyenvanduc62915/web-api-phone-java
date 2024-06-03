package com.example.webapiphonejava.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;
    @Column(name = "customer_name")
    @Size(max = 25, message = "Tên khách hàng cho phép tốt đa là 25 ký tự!")
    private String customerName;
    @Column(name = "phone_number")
    @Size(max = 15, message = "Số điện thoại khách hàng cho phép tốt đa là 15 ký tự!")
    private String phoneNumber;
    @Column(name = "email")
    @Size(max = 100, message = "Email khách hàng cho phép tốt đa là 100 ký tự!")
    private String email;
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Bill> bills;
}