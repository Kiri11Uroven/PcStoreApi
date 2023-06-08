package com.MyIdeas.pcStore.service.impl;

import com.MyIdeas.pcStore.common.InfoMessagesConstants;
import com.MyIdeas.pcStore.dto.request.ProductCreationRequest;
import com.MyIdeas.pcStore.dto.response.ProductCreationResponse;
import com.MyIdeas.pcStore.entity.Product;
import com.MyIdeas.pcStore.mapper.ProductMapper;
import com.MyIdeas.pcStore.repository.ProductRepository;
import com.MyIdeas.pcStore.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final ProductMapper productMapper;

    @Override
    public ProductCreationResponse create(ProductCreationRequest creationRequest) {
        log.info(InfoMessagesConstants.CREATE_PRODUCT, creationRequest);

        Product product = productMapper.toProduct(creationRequest);
        Product createdProduct = repository.save(product);

        log.info(InfoMessagesConstants.PRODUCT_CREATED, product);

        return productMapper.toProductCreationResponse(createdProduct);
    }

    @Override
    public List<Product> getByType(String type) {
        return repository.findAllByType(type);
    }

    @Override
    public Product update(long id, Product product) {
        return null;
    }

    public Product getById(long id) {
        return repository.findById(id);
    }
}
