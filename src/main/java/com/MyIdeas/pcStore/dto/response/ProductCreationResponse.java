package com.MyIdeas.pcStore.dto.response;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class ProductCreationResponse {
    UUID id;
}
