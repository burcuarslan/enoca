package com.example.enoca.business.responses;

import com.example.enoca.entities.concretes.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCategoryResponse {
    private int id;

    private String categoryName;

    private List<GetOnlyProductResponse> products;
}
