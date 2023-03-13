package com.example.enoca.business.rules;

import com.example.enoca.core.utilities.exceptions.BusinessException;
import com.example.enoca.dataAccess.abstracts.CategoryRepository;
import org.springframework.stereotype.Service;


@Service
public class CategoryBusinessRules {

    private CategoryRepository categoryRepository;

    public CategoryBusinessRules(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void checkIfCategoryNameExists(String categoryName) {
        if (categoryRepository.existsByCategoryName(categoryName)) {
            throw new BusinessException("Category name already exists");
        }
    }

    public void checkIfCategoryIdExists(int categoryId) {
        if (!categoryRepository.existsById(categoryId)) {
            throw new BusinessException("Category id does not exist");
        }
    }


}
