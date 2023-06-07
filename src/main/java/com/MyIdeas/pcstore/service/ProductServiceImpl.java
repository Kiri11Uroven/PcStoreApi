package com.MyIdeas.pcstore.service;

import com.MyIdeas.pcstore.exceptionHandler.NullProductPropertiesException;
import com.MyIdeas.pcstore.entity.Product;
import com.MyIdeas.pcstore.repo.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Optional;
@Api("Сервисный класс обработки сущностей товара")
@org.springframework.stereotype.Service
public class ProductServiceImpl implements Service {
   private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }
    @ApiOperation("Метод проверки количества товара для")
    private int quantityCheck(Product product) {
        return repository.countByProperties(product.getProperties());
    }
    @ApiOperation("Метод проверки наличия товара")
    private boolean availabilityCheck(Product product) {
        Optional<Product> tmp = Optional.ofNullable(repository
                .findByTypeAndSeriesNumberAndManufacturerAndPriceAndProperties(product.getType(),
                        product.getSeriesNumber(),
                        product.getManufacturer(),
                        product.getPrice(),
                        product.getProperties()));
        return tmp.isPresent();
    }
    @ApiOperation("Метод проверки количества товара для update")
    private boolean quantityCheck(long id) {
        Product product = repository.findById(id);
        return product.getQuantity() > 1;
    }
    @ApiOperation("Метод проверки полноты передаваемых данных для сущности товара")
    private void productCheck(Product product) {
        if (product.getType() == null) {
            throw new NullProductPropertiesException("Поле 'тип' не должно быть пустым");
        }
        if (product.getProperties() == null) {
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
    @ApiOperation("Сервисный метод добавления нового товара")
    @Override
    public Product add(Product product) {
        productCheck(product);
        if (availabilityCheck(product)) {
            repository.updateQuantity(product.getProperties());
        } else {
            Product newProduct = Product.builder()
                    .manufacturer(product.getManufacturer())
                    .price(product.getPrice())
                    .properties(product.getProperties())
                    .quantity(quantityCheck(product) + 1)
                    .seriesNumber(product.getSeriesNumber())
                    .type(product.getType())
                    .build();
            repository.saveAndFlush(newProduct);
        }
        return product;
    }
    @ApiOperation("Сервисный метод получения товаров по типу")
    @Override
    public List<Product> getByType(String type) {
        return repository.findAllByType(type);
    }
    @ApiOperation("Сервисный метод редактирования товаров по id")
    @Override
    public Product update(long id, Product product) {
        productCheck(product);
        if (quantityCheck(id)) {
            repository.decrementQuantity(id);
            add(product);
        } else {
            repository.updateProductById(id, product.getType()
                    , product.getPrice()
                    , product.getSeriesNumber()
                    , product.getManufacturer()
                    , product.getProperties());
        }
        return product;
    }
    @ApiOperation("Сервисный метод получения товаров по id")
    public Product getById(long id) {
        return repository.findById(id);
    }
}
