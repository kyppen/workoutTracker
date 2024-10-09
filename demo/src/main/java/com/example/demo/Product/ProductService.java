package com.example.demo.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepo productRepo;
    @Autowired
    public ProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    public Product getById(Long id){
        return productRepo.findById(id).orElse(null);
    }

    public Product saveProduct(Product product){
        return productRepo.save(product);
    }

    public List<Product> saveMultiple(List<Product> products){
        return productRepo.saveAll(products);
    }

    public List<Product> getAll(){
        return productRepo.findAll();
    }

}
