package com.example.enoca.business.concretes;

import com.example.enoca.business.abstracts.ProductService;
import com.example.enoca.business.requests.CreateProductRequest;
import com.example.enoca.business.requests.UpdateProductRequest;
import com.example.enoca.business.responses.GetAllProductsResponse;
import com.example.enoca.business.responses.GetProductResponse;
import com.example.enoca.business.rules.CategoryBusinessRules;
import com.example.enoca.business.rules.ProductBusinessRules;
import com.example.enoca.core.utilities.mappers.ModelMapperService;
import com.example.enoca.dataAccess.abstracts.ProductRepository;
import com.example.enoca.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductManager implements ProductService {

    private ProductRepository productRepository;
    private ModelMapperService modelMapperService;

    private ProductBusinessRules productBusinessRules;

    private CategoryBusinessRules categoryBusinessRules;

    @Autowired
    public ProductManager(ProductRepository productRepository, ModelMapperService modelMapperService, ProductBusinessRules productBusinessRules, CategoryBusinessRules categoryBusinessRules) {
        this.productRepository = productRepository;
        this.modelMapperService = modelMapperService;
        this.productBusinessRules = productBusinessRules;
        this.categoryBusinessRules = categoryBusinessRules;
    }

    @Override
    public List<GetAllProductsResponse> getAll() {
        List<Product> products = this.productRepository.findAll();
        List<GetAllProductsResponse> getAllProductsResponse = products.stream()
                .map(product -> this.modelMapperService.forResponse().map(product, GetAllProductsResponse.class))
                .collect(Collectors.toList());

        return getAllProductsResponse;

    }

    @Override
    public void add(CreateProductRequest createProduct) {
        this.categoryBusinessRules.checkIfCategoryIdExists(createProduct.getCategoryId());
        this.productBusinessRules.checkIfProductNameExists(createProduct.getProductName());
        Product product = this.modelMapperService.forRequest().map(createProduct, Product.class);
//        Product product = new Product();
//        product.setProductName(createProduct.getProductName());
//        product.setUnitPrice(createProduct.getUnitPrice());
//        product.setUnitsInStock(createProduct.getUnitsInStock());
//        product.setCategory(categoryRepository.findById(createProduct.getCategoryId()).orElse(null));
        this.productRepository.save(product);

    }

    @Override
    public void update(UpdateProductRequest updateProductRequest) {
        this.productBusinessRules.checkIfProductIdExists(updateProductRequest.getId());
        Product product = this.modelMapperService.forRequest()
                .map(updateProductRequest, Product.class);

        this.productRepository.save(product);

    }

    @Override
    public void delete(int id) {
        this.productBusinessRules.checkIfProductIdExists(id);
        this.productRepository.deleteById(id);
    }


    @Override
    public GetProductResponse getById(int id) {
        this.productBusinessRules.checkIfProductIdExists(id);
        Product product= this.productRepository.findById(id).get();
//        return product;
        return this.modelMapperService.forResponse().map(product, GetProductResponse.class);
    }
}
