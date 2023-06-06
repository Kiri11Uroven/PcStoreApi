package com.MyIdeas.PcStore.repo;

import com.MyIdeas.PcStore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Transactional
    @Modifying
    @Query("update Product p set p.type = :type," +
            " p.manufacturer = :manufacturer," +
            " p.quantityInStock = :quantityInStock," +
            " p.seriesNumber = :seriesNumber," +
            " p.productProperties = :productProperties," +
            " p.price = :price")
    void updateTypeAndManufacturerAndQuantityInStockAndSeriesNumberAndProductPropertiesAndPriceBy(@Param("type") String type,
                                                                                                  @Param("price") double price,
                                                                                                  @Param("quantityInStock") int quantityInStock,
                                                                                                  @Param("manufacturer") String manufacturer,
                                                                                                  @Param("seriesNumber") String seriesNumber);

    int countByProductProperties(String type);
    Product findById(long id);

    boolean existsByPriceAndManufacturerAndProductPropertiesAndSeriesNumber(BigDecimal price,
                                                                            String manufacturer,
                                                                            String productProperties,
                                                                            long seriesNumber);

    Product findByTypeAndSeriesNumberAndManufacturerAndPriceAndProductProperties(String type,
                                                                                 long seriesNumber,
                                                                                 String manufacturer,
                                                                                 BigDecimal price,
                                                                                 String productProperties);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE Products SET quantity = quantity +1  WHERE properties = :properties")
    int updateQuanity(String properties);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "Update Products SET type = :type," +
            "price = :price," +
            "serial_number = :serial_number," +
            "manufacturer=:manufacturer," +
            "properties =:properties WHERE id = :id")

    int updateProductById(long id, String type, BigDecimal price, long serial_number, String manufacturer, String properties);

    List<Product> findAllByType(String type);
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE Products SET quantity = quantity -1  WHERE id = :id")
    int dicrementQuanity(long id);

}
