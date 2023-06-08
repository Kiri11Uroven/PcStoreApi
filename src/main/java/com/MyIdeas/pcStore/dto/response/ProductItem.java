package com.MyIdeas.pcStore.dto.response;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ProductItem {
    String seriesNumber;

    String name;
}
