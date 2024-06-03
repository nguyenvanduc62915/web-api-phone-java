package com.example.webapiphonejava.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;
    @Column(name = "name")
    @Size(max = 50, message = "Tên người dùng cho phép tốt đa là 50 ký tự!")
    private String name;
    @Column(name = "user_name")
    @Size(max = 50, message = "Tài khoản người dùng cho phép tốt đa là 50 ký tự!")
    private String userName;
    @Column(name = "password")
    @Size(max = 25, message = "Mật khẩu người dùng cho phép tốt đa là 25 ký tự!")
    private String password;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
}
