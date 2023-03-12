package com.example.enoca.business.abstracts;

import com.example.enoca.business.requests.CreateCategoryRequest;
import com.example.enoca.business.requests.CreateProductRequest;
import com.example.enoca.business.requests.UpdateCategoryRequest;
import com.example.enoca.business.requests.UpdateProductRequest;
import com.example.enoca.business.responses.GetAllCategoriesResponse;
import com.example.enoca.business.responses.GetAllProductsResponse;

import java.util.List;

public interface CategoryService {
    List<GetAllCategoriesResponse> getAll();

    void add(CreateCategoryRequest createCategory);

    void update(UpdateCategoryRequest updateCategoryRequest);

    void delete(int id);
}
