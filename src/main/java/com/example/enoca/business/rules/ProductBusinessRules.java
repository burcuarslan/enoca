package com.example.enoca.business.rules;

import com.example.enoca.dataAccess.abstracts.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductBusinessRules extends RuntimeException{

    private ProductRepository productRepository;

    public ProductBusinessRules(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void checkIfProductNameExists(String productName) {
        if (productRepository.existsByProductName(productName)) {
            throw new RuntimeException("Product name already exists");
        }
    }

    public void checkIfProductIdExists(int productId) {
        if (!productRepository.existsById(productId)) {
            throw new RuntimeException("Product id does not exist");
        }
    }
}
