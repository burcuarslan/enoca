package com.example.enoca.business.rules;

import com.example.enoca.core.utilities.exceptions.BusinessException;
import com.example.enoca.dataAccess.abstracts.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductBusinessRules {

    private ProductRepository productRepository;

    public ProductBusinessRules(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void checkIfProductNameExists(String productName) {
        if (productRepository.existsByProductName(productName)) {
            throw new BusinessException("Product name already exists");
        }
    }

    public void checkIfProductIdExists(int productId) {
        if (!productRepository.existsById(productId)) {
            throw new BusinessException("Product id does not exist");
        }
    }
}
