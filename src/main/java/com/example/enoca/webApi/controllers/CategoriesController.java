package com.example.enoca.webApi.controllers;

import com.example.enoca.business.abstracts.CategoryService;
import com.example.enoca.business.requests.CreateCategoryRequest;
import com.example.enoca.business.requests.UpdateCategoryRequest;
import com.example.enoca.business.responses.GetAllCategoriesResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //annotation
@RequestMapping(value = "/api/categories") //url
public class CategoriesController {

    private CategoryService categoryService;

    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @Operation(summary = "Get all categories")
    @GetMapping()
    public List<GetAllCategoriesResponse> getAll() {
        return this.categoryService.getAll();
    }

    @Operation(summary = "Add a new category")
    @PostMapping()
    public void add(CreateCategoryRequest createCategory) {
        this.categoryService.add(createCategory);
    }

    @Operation(summary = "Update a category")
    @PutMapping()
    public void update(@RequestBody() UpdateCategoryRequest updateCategoryRequest) {
        this.categoryService.update(updateCategoryRequest);
    }

    @Operation(summary = "Delete a category")
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        this.categoryService.delete(id);
    }

}
