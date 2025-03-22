package com.dev.ecommercebackend.repository;


import com.dev.ecommercebackend.model.Product;
import com.dev.ecommercebackend.model.ProductCategory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryRepository categoryRepository;

    @Order(1)
    @Test
    public void testIfThereAreSomeProducts() {
        List<Product> all = productRepository.findAll();
        Assertions.assertThat(all.size()).isGreaterThan(0);
    }


//    @Rollback(value = false)
    @Order(2)
    @Commit
    @Test
    public void testInsertNewProduct(){
        Product product = new Product();
        product.setActive(true);
        product.setName("test 1345");
        product.setSku("23KREU");
        product.setUnitPrice(BigDecimal.valueOf(344.3f));

        Optional<ProductCategory> category = categoryRepository.findById(3L);
        category.ifPresent(cat -> {
            product.setCategory(cat);
        });

        Product saved = productRepository.save(product);

        Assertions.assertThat(saved).isNotNull();

    }

    @Order(3)
    @Test
    public void checkIfTestCategoryCreated(){
        Product product = productRepository.findProductByName("test 1345");

        Assertions.assertThat(product.getName()).isEqualTo("test 1345");
    }
}
