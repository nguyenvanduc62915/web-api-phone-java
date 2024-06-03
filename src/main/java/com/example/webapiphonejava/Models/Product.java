package com.example.webapiphonejava.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;
    @Column(name = "product_name")
    @Size(max = 100, message = "Tên sản phẩm cho phép tối đa 100 kỹ tự!")
    private String productName;
    @Column(name = "product_image")
    @Max(value = 50, message = "Ảnh sản phẩm cho phép tối đa 100 kỹ tự!")
    private int productImage;
    @Column(name = "price")
    private int price;
    @Column(name = "amount")
    private int amount;
    @Column(name = "dimensio")
    @Size(max = 255, message = "Kích thước sản phẩm tối đâ 255 ký tự!")
    private String dimension;
    @Column(name = "weight")
    @Size(max = 255, message = "Trọng lượng sản phẩm tối đâ 255 ký tự!")
    private String weight;
    @Column(name = "color")
    @Size(max = 255, message = "Màu sắc sản phẩm tối đâ 255 ký tự!")
    private String color;
    @Column(name = "sound")
    @Size(max = 255, message = "Âm thanh sản phẩm tối đâ 255 ký tự!")
    private String sound;
    @Column(name = "memory")
    @Size(max = 255, message = "Bộ nhớ sản phẩm tối đâ 255 ký tự!")
    private String memory;
    @Column(name = "operating_system")
    @Size(max = 255, message = "Hệ điêù hành sản phẩm tối đâ 255 ký tự!")
    private String operatingSystem;
    @Column(name = "memory_card")
    @Size(max = 255, message = "Thẻ nhớ sản phẩm tối đâ 255 ký tự!")
    private String memoryCard;
    @Column(name = "camera")
    @Size(max = 255, message = "Camera sản phẩm tối đâ 255 ký tự!")
    private String camera;
    @Column(name = "battery")
    @Size(max = 255, message = "Pin sản phẩm tối đâ 255 ký tự!")
    private String battery;
    @Column(name = "warranty")
    @Size(max = 255, message = "Bảo hành sản phẩm tối đâ 255 ký tự!")
    private String warranty;
    @Column(name = "connection")
    @Size(max = 255, message = "Kết nối các thiết bị của sản phẩm tối đâ 255 ký tự!")
    private String connection;
    @Column(name = "sale")
    private int sale;
    @Column(name = "start_sale")
    private LocalDate startSale;
    @Column(name = "end_sale")
    private LocalDate endSale;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "FK_CATEGORY_PRODUCT"))
    private Category category;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Comment> comments;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<BillDetails> billDetails;
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ProductsOfSale> productsOfSales;
}