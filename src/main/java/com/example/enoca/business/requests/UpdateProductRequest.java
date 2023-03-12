package com.example.enoca.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {

        @NotNull
        @NotBlank
        @Size(min = 0)
        private int id;

        @NotNull
        @NotBlank
        @Size(min = 2, max = 50)
        private String productName;

        @NotNull
        @NotBlank
        @Size(min = 0)
        private int unitPrice;

        @NotNull
        @NotBlank
        @Size(min = 0)
        private int unitsInStock;

        @NotNull
        @NotBlank
        @Size(min = 0)
        private int quantityPerUnit;

        @NotNull
        @NotBlank

        private int categoryId;
}
