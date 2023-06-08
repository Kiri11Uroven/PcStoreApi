package com.MyIdeas.pcStore.controller;

import com.MyIdeas.pcStore.common.ApiPathConstants;
import com.MyIdeas.pcStore.dto.request.ProductCreationRequest;
import com.MyIdeas.pcStore.dto.response.ProductCreationResponse;
import com.MyIdeas.pcStore.dto.response.ProductItem;
import com.MyIdeas.pcStore.entity.Product;
import com.MyIdeas.pcStore.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ProductController implements ProductApi {
    private final ProductService productService;

    @GetMapping(ApiPathConstants.PRODUCT_ID)
    public ProductItem getById(@PathVariable UUID id) {
        return ProductItem.builder()
                .seriesNumber("1111")
                .build();
    }

    @PostMapping(ApiPathConstants.PRODUCT)
    public ResponseEntity<ProductCreationResponse> createProduct(
            @Valid @RequestBody ProductCreationRequest creationRequest) {
        return ResponseEntity.ok(productService.create(creationRequest));
    }

    @Operation(summary = "Получение списка товаров по типу")
    @GetMapping(ApiPathConstants.PRODUCT_TYPE)
    public List<Product> getByType(@PathVariable @Parameter(description = "Передаваемый тип товара") String type) {
        return productService.getByType(type);
    }


    @Operation(summary = "Редактирование товаров по id")
    @PutMapping(ApiPathConstants.PRODUCT_ID)
    public Product update(@PathVariable int id, @RequestBody Product product) {
        return productService.update(id, product);
    }
}
