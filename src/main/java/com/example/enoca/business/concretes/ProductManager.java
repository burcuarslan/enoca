package com.example.enoca.business.concretes;

import com.example.enoca.business.abstracts.ProductService;
import com.example.enoca.business.requests.CreateProductRequest;
import com.example.enoca.business.requests.UpdateProductRequest;
import com.example.enoca.business.responses.GetAllProductsResponse;
import com.example.enoca.core.utilities.mappers.ModelMapperService;
import com.example.enoca.dataAccess.abstracts.ProductRepository;
import com.example.enoca.entities.concretes.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductManager implements ProductService {

    private ProductRepository productRepository;
    private ModelMapperService modelMapperService;

    public ProductManager(ProductRepository productRepository, ModelMapperService modelMapperService) {
        this.productRepository = productRepository;
        this.modelMapperService = modelMapperService;
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
        Product product = this.modelMapperService.forRequest().map(createProduct, Product.class);

        this.productRepository.save(product);
    }

    @Override
    public void update(UpdateProductRequest updateProductRequest) {
        Product product = this.modelMapperService.forRequest().map(updateProductRequest, Product.class);

        this.productRepository.save(product);
    }

    @Override
    public void delete(int id) {
        this.productRepository.deleteById(id);
    }
}
