package com.example.enoca.business.abstracts;

import com.example.enoca.business.requests.CreateProductRequest;
import com.example.enoca.business.requests.UpdateProductRequest;
import com.example.enoca.business.responses.GetAllProductsResponse;
import com.example.enoca.business.responses.GetProductResponse;
import com.example.enoca.entities.concretes.Product;

import java.util.List;
/**
 * Business katmanı için Product service interface
 */
public interface ProductService {

    /**
     * Tüm ürünleri getirir
     * @return
     */
    List<GetAllProductsResponse> getAll();

    /**
     * Ürün ekler
     * @param createProduct
     */
    void add(CreateProductRequest createProduct);

    /**
     * Ürün günceller
     * @param updateProductRequest
     */
    void update(UpdateProductRequest  updateProductRequest);


    /**
     * Ürün siler
     * @param id
     */
    void delete(int id);

    /**
     * Ürün id'sine göre ürün getirir
     * @param id
     * @return
     */
    GetProductResponse getById(int id);

}
