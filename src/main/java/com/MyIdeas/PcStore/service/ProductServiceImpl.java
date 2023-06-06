package com.MyIdeas.PcStore.service;

import com.MyIdeas.PcStore.exceptionHandler.NullProductPropertiesException;
import com.MyIdeas.PcStore.entity.Product;
import com.MyIdeas.PcStore.repo.ProductRepository;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ProductServiceImpl implements Service {
    ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    private int quantityCheck(Product product) {
        return repository.countByProductProperties(product.getProductProperties());
    }

    private boolean availabilityCheck(Product product) {
        Optional<Product> tmp = Optional.ofNullable(repository
                .findByTypeAndSeriesNumberAndManufacturerAndPriceAndProductProperties(product.getType(),
                        product.getSeriesNumber(),
                        product.getManufacturer(),
                        product.getPrice(),
                        product.getProductProperties()));
        return tmp.isPresent();
    }

    private boolean quantityCheck(long id) {
        Product product = repository.findById(id);
        return product.getQuantityInStock() > 1;
    }

    private void productCheck(Product product) {
        if (product.getType() == null) {
            throw new NullProductPropertiesException("Поле 'тип' не должно быть пустым");
        }
        if (product.getProductProperties() == null) {
            throw new NullProductPropertiesException("Поле 'свойства товара' не должно быть пустым");
        }
        if (product.getManufacturer() == null) {
            throw new NullProductPropertiesException("Поле 'производитель' не должно быть пустым");
        }
        if (product.getPrice() == null) {
            throw new NullProductPropertiesException("Поле 'цена' не должно быть пустым");
        }
        if (product.getSeriesNumber() == null) {
            throw new NullProductPropertiesException("Поле 'серийный номер' не должно быть пустым");
        }
    }

    @Override
    public Product add(Product product) {
        productCheck(product);
        if (availabilityCheck(product)) {
            repository.updateQuanity(product.getProductProperties());
        } else {
            Product newProduct = new Product();
            newProduct.setProductProperties(product.getProductProperties());
            newProduct.setType(product.getType());
            newProduct.setSeriesNumber(product.getSeriesNumber());
            newProduct.setPrice(product.getPrice());
            newProduct.setManufacturer(product.getManufacturer());
            newProduct.setQuantityInStock(quantityCheck(product) + 1);
            repository.saveAndFlush(newProduct);
        }
        return product;
    }

    @Override
    public List<Product> getByType(String type) {
        return repository.findAllByType(type);
    }

    @Override
    public Product update(long id, Product product) {
        productCheck(product);
        if (quantityCheck(id)) {
            repository.dicrementQuanity(id);
            add(product);
        } else {
            repository.updateProductById(id, product.getType()
                    , product.getPrice()
                    , product.getSeriesNumber()
                    , product.getManufacturer()
                    , product.getProductProperties());
        }
        return product;
    }

    public Product getById(long id) {
        return repository.findById(id);
    }
}
