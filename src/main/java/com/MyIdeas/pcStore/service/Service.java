package com.MyIdeas.pcStore.service;

import com.MyIdeas.pcStore.entity.Product;

import java.util.List;

public interface Service {
    Product add(Product product);
    Product getById(long id);
    List<Product> getByType(String type);
    Product update(long id,Product product);

}
