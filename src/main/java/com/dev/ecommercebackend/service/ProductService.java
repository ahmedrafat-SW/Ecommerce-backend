package com.dev.ecommercebackend.service;

import com.dev.ecommercebackend.model.Product;
import com.dev.ecommercebackend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional(isolation = Isolation.REPEATABLE_READ)

    @Cacheable(value = "product" , key = "#id")
    public Product getProductById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    @Cacheable(value = "productsList")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}
