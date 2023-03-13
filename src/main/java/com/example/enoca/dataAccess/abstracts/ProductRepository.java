package com.example.enoca.dataAccess.abstracts;

import com.example.enoca.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    boolean existsByProductName(String productName);
}
