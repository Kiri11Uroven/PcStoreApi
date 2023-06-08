package com.MyIdeas.pcStore.service;

import com.MyIdeas.pcStore.dto.request.ProductCreationRequest;
import com.MyIdeas.pcStore.dto.response.ProductCreationResponse;
import com.MyIdeas.pcStore.dto.response.ProductItem;
import com.MyIdeas.pcStore.entity.Product;

import java.util.List;

public interface ProductService {
    ProductCreationResponse create(ProductCreationRequest creationRequest);

    List<Product> getByType(String type);

    Product update(long id, Product product);
}
