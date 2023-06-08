package com.MyIdeas.pcStore.dto.request;

import com.MyIdeas.pcStore.entity.ProductType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
@ToString
@Schema(description = "Запрос на создание продукта.")
public class ProductCreationRequest {
    @NotNull
    @Schema(description = "Тип продукта.", example = "MONITOR")
    ProductType type;

    @NotBlank
    @Schema(description = "Номер серии.", example = "22-ВБА-87")
    String seriesNumber;

    @NotBlank
    @Schema(description = "Производитель.", example = "Samsung")
    String manufacturer;

    @NotNull
    @Schema(description = "Цена за единицу продукта.")
    BigDecimal price;

    @NotNull
    @Schema(description = "Количество единиц продукта.")
    Integer quantity;

    @NotBlank
    @Schema(description = "Дополнительный атрибут.", example = "17'")
    String additionalProperty;
}
