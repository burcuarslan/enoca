package com.example.enoca.business.concretes;

import com.example.enoca.business.abstracts.CategoryService;
import com.example.enoca.business.requests.CreateCategoryRequest;
import com.example.enoca.business.requests.UpdateCategoryRequest;
import com.example.enoca.business.responses.GetAllCategoriesResponse;
import com.example.enoca.business.responses.GetCategoryResponse;
import com.example.enoca.business.rules.CategoryBusinessRules;
import com.example.enoca.core.utilities.mappers.ModelMapperService;
import com.example.enoca.dataAccess.abstracts.CategoryRepository;
import com.example.enoca.entities.concretes.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryManager implements CategoryService {
    private CategoryRepository categoryRepository;
    private ModelMapperService modelMapperService;

    private CategoryBusinessRules categoryBusinessRules;

    public CategoryManager(CategoryRepository categoryRepository, ModelMapperService modelMapperService, CategoryBusinessRules categoryBusinessRules) {
        this.categoryRepository = categoryRepository;
        this.modelMapperService = modelMapperService;
        this.categoryBusinessRules = categoryBusinessRules;
    }

    @Override
    public List<GetAllCategoriesResponse> getAll() {
        List<Category> categories = categoryRepository.findAll();
        List<GetAllCategoriesResponse> getAllCategoriesResponse = categories.stream()
                .map(category -> this.modelMapperService.forResponse().map(category, GetAllCategoriesResponse.class))
                .collect(Collectors.toList());

        return getAllCategoriesResponse;
    }

    @Override
    public void add(CreateCategoryRequest createCategory) {
        this.categoryBusinessRules.checkIfCategoryNameExists(createCategory.getCategoryName());
        Category category = this.modelMapperService.forRequest().map(createCategory, Category.class);

        this.categoryRepository.save(category);
    }

    @Override
    public void update(UpdateCategoryRequest updateCategoryRequest) {
        this.categoryBusinessRules.checkIfCategoryIdExists(updateCategoryRequest.getId());
        Category category = this.modelMapperService.forRequest().map(updateCategoryRequest, Category.class);

        this.categoryRepository.save(category);
    }

    @Override
    public void delete(int id) {
        this.categoryBusinessRules.checkIfCategoryIdExists(id);
        this.categoryRepository.deleteById(id);
    }

    @Override
    public GetCategoryResponse getById(int id) {
        this.categoryBusinessRules.checkIfCategoryIdExists(id);
        Category category = this.categoryRepository.findById(id).orElse(null);
        GetCategoryResponse getCategoriesResponse = this.modelMapperService.forResponse().map(category, GetCategoryResponse.class);
        return getCategoriesResponse;
    }
}
