package com.example.enoca.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOnlyProductResponse {
    private int id;
    private String productName;

    private int unitPrice;

    private int unitsInStock;

    private int quantityPerUnit;
}
