package com.MyIdeas.pcStore.common;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ErrorMessagesConstants {
    public static final String INVALID_PRODUCT_UNIQUE_CONSTRAINT =
            "[PCS-E001] Product with requested data already exists: %s";
}
