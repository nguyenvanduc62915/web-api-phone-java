package com.example.webapiphonejava.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "shippers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shipper extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipper_id")
    private int id;
    @Column(name = "shipper_name")
    @Size(max = 50, message = "Tên nhân viên giao hàng tối ta 50 ký tự!")
    private String shipperName;
    @Column(name = "phone_shipper_one")
    @Size(max = 11, message = "Số điện thoại tối đa 11 ký tự!")
    private String phoneShipperOne;
    @Column(name = "phone_shipper_two")
    @Size(max = 11, message = "Số điện thoại tối đa 11 ký tự!")
    private String phoneShipperTwo;
    @OneToMany(mappedBy = "shipper", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Bill> bills;
}
