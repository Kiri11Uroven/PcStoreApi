package com.MyIdeas.pcStore.repository;

import com.MyIdeas.pcStore.entity.Product;
import com.MyIdeas.pcStore.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findById(long id);

    List<Product> findAllByType(String type);

    boolean existsByTypeAndSeriesNumberAndManufacturerAndAdditionalProperty(
            ProductType type, String seriesNumber, String manufacturer, String additionalProperty);
}
