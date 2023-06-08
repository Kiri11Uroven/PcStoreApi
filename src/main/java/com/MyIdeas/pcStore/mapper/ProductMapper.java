package com.MyIdeas.pcStore.mapper;

import com.MyIdeas.pcStore.config.MapStructConfig;
import com.MyIdeas.pcStore.dto.request.ProductCreationRequest;
import com.MyIdeas.pcStore.dto.response.ProductCreationResponse;
import com.MyIdeas.pcStore.entity.Product;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfig.class)
public interface ProductMapper {
    /**
     * Преобразовать {@link ProductCreationRequest} в {@link Product}.
     *
     * @param source {@link ProductCreationRequest}
     * @return {@link Product}
     */
    Product toProduct(ProductCreationRequest source);

    /**
     * Преобразовать {@link Product} в {@link ProductCreationResponse}.
     *
     * @param source {@link Product}
     * @return {@link ProductCreationResponse}
     */
    ProductCreationResponse toProductCreationResponse(Product source);
}
