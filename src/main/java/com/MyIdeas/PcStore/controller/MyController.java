package com.MyIdeas.PcStore.controller;

import com.MyIdeas.PcStore.entity.Product;
import com.MyIdeas.PcStore.service.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {
    Service service;

    public MyController(Service service) {
        this.service = service;
    }

    @PostMapping("/products")
    public Product addNewProduct(@RequestBody Product product) {
       return service.add(product);
    }

    @GetMapping("/products/type/{type}")
    public List<Product> getByType(@PathVariable String type) {
        return service.getByType(type);
    }

    @GetMapping("/products/id/{id}")
    public Product getById(@PathVariable long id) {
       return  service.getById(id);
    }

    @PutMapping("/products/{id}")
    public Product update(@PathVariable int id, @RequestBody Product product) {
       return service.update(id,product);
    }
}
