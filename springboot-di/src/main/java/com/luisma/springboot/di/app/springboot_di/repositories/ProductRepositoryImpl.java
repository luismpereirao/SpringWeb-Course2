package com.luisma.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;

import com.luisma.springboot.di.app.springboot_di.models.Product;

@Primary
@RequestScope
@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository{

    private List<Product> data;

    public ProductRepositoryImpl() {
        this.data = Arrays.asList(
                new Product(1L, "Memoria Corsair 32", 300L),
                new Product(2L, "CPU Intel Core i9", 850L),
                new Product(3L, "Teclado Razer Mini 60%", 100L),
                new Product(4L, "MotherBoard Gigabyte", 490L));
    }

    @Override
    public List<Product> findAll() {
        return data;
    }

    @Override
    public Product findById(Long id) {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

}
