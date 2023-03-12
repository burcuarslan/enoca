package com.example.enoca.webApi.controllers;

import com.example.enoca.business.abstracts.ProductService;
import com.example.enoca.business.requests.CreateProductRequest;
import com.example.enoca.business.requests.UpdateProductRequest;
import com.example.enoca.business.responses.GetAllProductsResponse;
import com.example.enoca.entities.concretes.Product;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //annotation
@RequestMapping(value = "/api/products") //url

public class ProductsController {

    private ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<GetAllProductsResponse> getAll() {
        return this.productService.getAll();
    }

    @PostMapping()
    @ResponseStatus(value = HttpStatus.CREATED)
    public void add(@RequestBody() CreateProductRequest createProductRequest) {
        this.productService.add(createProductRequest);
    }

    @PutMapping()
    public void update(@RequestBody() UpdateProductRequest updateProductRequest) {
        this.productService.update(updateProductRequest);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        this.productService.delete(id);
    }

}
