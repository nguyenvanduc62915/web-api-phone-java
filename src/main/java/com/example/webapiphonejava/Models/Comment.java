package com.example.webapiphonejava.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int id;
    @Column(name = "full_name")
    @Size(max = 25, message = "Họ và tên tối đa 25 ký tự!")
    private String fullName;
    @Column(name = "date_and_time")
    private LocalDate dateAndTime;
    @Column(name = "content")
    @Size(max = 255, message = "Nội dung người bình luận tối ta 255 ký tự!")
    private String content;
    @Column(name = "phone")
    @Size(max = 25, message = "Điện người bình luận tối ta 25 ký tự!")
    private String phone;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "FK_PRODUCT_COMMENT"))
    private Product product;
}