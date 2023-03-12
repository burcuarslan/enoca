package com.example.enoca.business.concretes;

import com.example.enoca.business.abstracts.CategoryService;
import com.example.enoca.business.requests.CreateCategoryRequest;
import com.example.enoca.business.requests.UpdateCategoryRequest;
import com.example.enoca.business.responses.GetAllCategoriesResponse;
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

    public CategoryManager(CategoryRepository categoryRepository, ModelMapperService modelMapperService) {
        this.categoryRepository = categoryRepository;
        this.modelMapperService = modelMapperService;
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
        Category category = this.modelMapperService.forRequest().map(createCategory, Category.class);

        this.categoryRepository.save(category);
    }

    @Override
    public void update(UpdateCategoryRequest updateCategoryRequest) {
        Category category = this.modelMapperService.forRequest().map(updateCategoryRequest, Category.class);

        this.categoryRepository.save(category);
    }

    @Override
    public void delete(int id) {
        this.categoryRepository.deleteById(id);
    }
}
