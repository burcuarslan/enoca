package com.example.enoca.dataAccess.abstracts;

import com.example.enoca.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    boolean existsByCategoryName(String categoryName);
}
