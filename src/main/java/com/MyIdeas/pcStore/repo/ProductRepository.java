package com.MyIdeas.pcStore.repo;

import com.MyIdeas.pcStore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    int countByProperties(String type);

    Product findById(long id);

    Product findByTypeAndSeriesNumberAndManufacturerAndPriceAndProperties(String type,
                                                                          Long seriesNumber,
                                                                          String manufacturer,
                                                                          BigDecimal price,
                                                                          String properties);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE Products SET quantity = quantity +1  WHERE properties = :properties")
    int updateQuantity(String properties);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "Update Products SET type = :type," +
            "price = :price," +
            "series_Number = :seriesNumber," +
            "manufacturer=:manufacturer," +
            "properties =:properties WHERE id = :id")

    int updateProductById(Long id, String type, BigDecimal price, Long seriesNumber, String manufacturer, String properties);

    List<Product> findAllByType(String type);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE Products SET quantity = quantity -1  WHERE id = :id")
    void decrementQuantity(long id);

}
