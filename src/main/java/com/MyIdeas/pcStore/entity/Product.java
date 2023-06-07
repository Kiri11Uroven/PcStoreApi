package com.MyIdeas.pcStore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Products")
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private Long seriesNumber;
    private String manufacturer;
    private BigDecimal price;
    private int quantity;
    private String properties;
}
