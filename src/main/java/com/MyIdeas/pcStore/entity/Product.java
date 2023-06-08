package com.MyIdeas.pcStore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dat_product")
public class Product {
    @Id
    @Getter
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private UUID id;

    @Getter
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ProductType type;

    @Getter
    @Column(name = "series_number")
    private String seriesNumber;

    @Getter
    @Column(name = "manufacturer")
    private String manufacturer;

    @Getter
    @Column(name = "price")
    private BigDecimal price;

    @Getter
    @Column(name = "quantity")
    private int quantity;

    @Getter
    @Column(name = "additional_property")
    private String additionalProperty;

    public Product(ProductType type, String seriesNumber, String manufacturer,
                   BigDecimal price, Integer quantity, String additionalProperty) {
        this.type = type;
        this.seriesNumber = seriesNumber;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
        this.additionalProperty = additionalProperty;
    }
}
