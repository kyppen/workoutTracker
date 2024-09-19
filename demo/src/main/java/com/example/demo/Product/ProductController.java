package com.example.demo.Product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(final ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/test/{id}")
    public Product getProduct(@PathVariable Long id){
        return productService.getById(id);
    }

    @GetMapping("/test/all")
    public List<Product> getAllProducts(){
        return productService.getAll();
    }
    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @PostMapping("/multiple")
    List<Product> saveProducts(@RequestBody List<Product> products){
        return productService.saveMultiple(products);
    }
}
