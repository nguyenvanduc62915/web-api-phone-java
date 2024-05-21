package com.example.webapiphonejava.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "products_of_sales")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsOfSale extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "products_of_sale_id")
    private int id;
    @Column(name = "quantity")
    private int quantity;
    @OneToMany(mappedBy = "productsOfSale", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Product> products;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "FK_PRODUCT_PRODUCTSOFSALE"))
    private Product product;
}

