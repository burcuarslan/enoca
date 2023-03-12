package com.example.enoca.business.responses;

import com.example.enoca.entities.concretes.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductsResponse {

    private int id;
    private String productName;

    private int unitPrice;

    private int unitsInStock;

    private String categoryName;

}
