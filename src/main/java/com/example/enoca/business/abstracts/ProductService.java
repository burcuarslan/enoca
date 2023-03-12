package com.example.enoca.business.abstracts;

import com.example.enoca.business.requests.CreateProductRequest;
import com.example.enoca.business.requests.UpdateProductRequest;
import com.example.enoca.business.responses.GetAllProductsResponse;
import com.example.enoca.entities.concretes.Product;

import java.util.List;

public interface ProductService {

    List<GetAllProductsResponse> getAll();
    void add(CreateProductRequest createProduct);

    void update(UpdateProductRequest  updateProductRequest);


    void delete(int id);

}
