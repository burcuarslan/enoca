package com.example.enoca.business.rules;

import com.example.enoca.dataAccess.abstracts.CategoryRepository;

public class CategoryBusinessRules {

    private CategoryRepository categoryRepository;

    public void checkIfCategoryNameExists(String categoryName) {
        if (categoryRepository.existsByCategoryName(categoryName)) {
            throw new RuntimeException("Category name already exists");
        }
    }
}
