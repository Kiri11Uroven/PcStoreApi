package com.MyIdeas.pcStore.checker.impl;

import com.MyIdeas.pcStore.checker.ProductChecker;
import com.MyIdeas.pcStore.common.ErrorMessagesConstants;
import com.MyIdeas.pcStore.dto.request.ProductCreationRequest;
import com.MyIdeas.pcStore.exception.ValidationException;
import com.MyIdeas.pcStore.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductCheckerImpl implements ProductChecker {
    private final ProductRepository productRepository;

    @Override
    public void checkProductNotExists(ProductCreationRequest productCreationRequest) {
        if (productRepository
                .existsByTypeAndSeriesNumberAndManufacturerAndAdditionalProperty(
                        productCreationRequest.getType(), productCreationRequest.getSeriesNumber(),
                        productCreationRequest.getManufacturer(), productCreationRequest.getAdditionalProperty())) {
            throw new ValidationException(
                    String.format(ErrorMessagesConstants.INVALID_PRODUCT_UNIQUE_CONSTRAINT, productCreationRequest));
        }
    }
}
