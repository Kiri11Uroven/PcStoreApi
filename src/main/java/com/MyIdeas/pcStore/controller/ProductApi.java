package com.MyIdeas.pcStore.controller;

import com.MyIdeas.pcStore.dto.request.ProductCreationRequest;
import com.MyIdeas.pcStore.dto.response.ProductCreationResponse;
import com.MyIdeas.pcStore.dto.response.ProductItem;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Tag(name = "Product Api", description = "Api для работы с продуктами.")
public interface ProductApi {
    @Operation(summary = "Получить продукт по идентификатору.")
    ProductItem getById(@PathVariable UUID id);

    @Operation(summary = "Создать продукт.")
    ResponseEntity<ProductCreationResponse> createProduct(@Valid @RequestBody ProductCreationRequest creationRequest);
}
