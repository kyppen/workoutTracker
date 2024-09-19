package com.example.demo.Product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(generator = "Product_seq_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Product_seq_gen", sequenceName = "Product_seq", allocationSize = 1)
    @Column(name = "product_id")
    private Long ProductId = 0L;

    @Column(name="productname")
    private String productName;

    public Product(String name){
        this.productName = name;
    }



}
