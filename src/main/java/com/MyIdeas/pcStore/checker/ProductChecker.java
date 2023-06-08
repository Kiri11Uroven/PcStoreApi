package com.MyIdeas.pcStore.checker;

import com.MyIdeas.pcStore.dto.request.ProductCreationRequest;

public interface ProductChecker {
    void checkProductNotExists(ProductCreationRequest productCreationRequest);
}
