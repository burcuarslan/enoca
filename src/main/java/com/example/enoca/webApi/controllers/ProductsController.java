package com.example.enoca.webApi.controllers;

import com.example.enoca.business.abstracts.ProductService;
import com.example.enoca.business.requests.CreateProductRequest;
import com.example.enoca.business.requests.UpdateProductRequest;
import com.example.enoca.business.responses.GetAllProductsResponse;
import com.example.enoca.entities.concretes.Product;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * ProductsController
 * @RestController annotasyonu ile bu class bir controller olduğunu belirtiyoruz.
 * @RequestMapping ile de bu controller'ın hangi url ile çağrılacağını belirtiyoruz.
 */
@RestController //annotation
@RequestMapping(value = "/api/products") //url

public class ProductsController {

    /**
     * ProductService interface'ini implemente eden bir sınıfın referansını tutan değişken.
     * @Autowired ile de bu değişkene bir sınıfın referansı atanıyor.
     */
    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * @GetMapping ile bu method'un hangi url ile çağrılacağını belirtiyoruz.
     * @return GetAllProductsResponse tipindeki bir liste döndürüyoruz.
     */
    @Operation(summary = "Get all products")
    @GetMapping()
    public List<GetAllProductsResponse> getAll() {
        return this.productService.getAll();
    }

    /**
     * @GetMapping ile bu method'un hangi url ile çağrılacağını belirtiyoruz.
     * @PathVariable ile de bu method'un hangi parametreyi alacağını belirtiyoruz.
     * @ResponseStatus ile de bu method'un hangi http status kodu döndüreceğini belirtiyoruz.
     * @return Başarılı olursa 201 döndürüyoruz. Başarısız olursa main classta tanımladığımız exception handler'lar devreye giriyor.
     */
    @Operation(summary = "Add a new product")
    @PostMapping()
    @ResponseStatus(value = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid CreateProductRequest createProductRequest) {
        this.productService.add(createProductRequest);
    }

    /**
     * @GetMapping ile bu method'un hangi url ile çağrılacağını belirtiyoruz.
     * @PathVariable ile de bu method'un hangi parametreyi alacağını belirtiyoruz.
     * @return Başarılı olursa 200 döndürüyoruz. Başarısız olursa main classta tanımladığımız exception handler'lar devreye giriyor.
     */
    @Operation(summary = "Update a product")
    @PutMapping()
    public void update(@RequestBody() @Valid UpdateProductRequest updateProductRequest) {
        this.productService.update(updateProductRequest);
    }

    /**
     * @GetMapping ile bu method'un hangi url ile çağrılacağını belirtiyoruz.
     * @PathVariable ile de bu method'un hangi parametreyi alacağını belirtiyoruz.
     * @return Başarılı olursa 200 döndürüyoruz. Başarısız olursa main classta tanımladığımız exception handler'lar devreye giriyor.
     */
    @Operation(summary = "Delete a product")
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable int id) {
        this.productService.delete(id);
    }

}
