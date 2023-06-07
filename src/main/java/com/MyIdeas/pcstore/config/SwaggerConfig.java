package com.MyIdeas.pcstore.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Сервис интернет магазина",
                version = "1.0.0",
                contact = @Contact(
                        name = "Kirill Сhurilov",
                        email = "ila5264789@narod.ru"
                )
        )
)
public class SwaggerConfig {
}
