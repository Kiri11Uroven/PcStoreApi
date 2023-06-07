package com.MyIdeas.pcstore.controller;

import com.MyIdeas.pcstore.entity.Product;
import com.MyIdeas.pcstore.service.Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Контроллер", description = "Содержит Endpoint'ы для работы с товарами")
@RestController
public class ProductController {
   private final Service service;

    public ProductController(Service service) {
        this.service = service;
    }

    @Operation(summary = "Добавление нового товара", description = "Добавление нового товара в таблицу")
    @PostMapping("/products")
    public Product addNewProduct(@RequestBody Product product) {
       return service.add(product);
    }
    @Operation(summary = "Получение списка товаров по типу")
    @GetMapping("/products/type/{type}")
    public List<Product> getByType(@PathVariable @Parameter(description = "Передаваемый тип товара") String type) {
        return service.getByType(type);
    }
    @Operation(summary = "Получение конкретного товара по id")
    @GetMapping("/products/id/{id}")
    public Product getById(@PathVariable long id) {
       return  service.getById(id);
    }
    @Operation(summary = "Редактирование товаров по id")
    @PutMapping("/products/{id}")
    public Product update(@PathVariable int id, @RequestBody Product product) {
       return service.update(id,product);
    }
}
