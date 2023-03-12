package com.example.enoca.webApi.controllers;

import com.example.enoca.business.abstracts.CategoryService;
import com.example.enoca.business.requests.CreateCategoryRequest;
import com.example.enoca.business.requests.UpdateCategoryRequest;
import com.example.enoca.business.responses.GetAllCategoriesResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //annotation
@RequestMapping(value = "/api/categories") //url
public class CategoriesController {

    private CategoryService categoryService;

    public CategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping()
    public List<GetAllCategoriesResponse> getAll() {
        return this.categoryService.getAll();
    }

    @PostMapping()
    public void add( CreateCategoryRequest createCategory) {
        this.categoryService.add(createCategory);
    }

    @PutMapping()
    public void update(@RequestBody() UpdateCategoryRequest updateCategoryRequest) {
        this.categoryService.update(updateCategoryRequest);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        this.categoryService.delete(id);
    }

}
