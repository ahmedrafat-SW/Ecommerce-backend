package com.dev.ecommercebackend.api;

import com.dev.ecommercebackend.model.Product;
import com.dev.ecommercebackend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${baseUrl}/products")
@RequiredArgsConstructor
@CrossOrigin("http://localhost")
public class ProductController {

    private final ProductService productService;


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @GetMapping()
    public List<Product> getProducts(){
        return productService.getProducts();
    }


}
