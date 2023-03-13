package com.example.enoca.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {

    @NotNull

    private int id;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    private String productName;

    @NotNull
    private double unitPrice;
    @NotNull

    private int unitsInStock;
    @NotNull

    private int quantityPerUnit;
    /**
     * @Column(name = "category_id") : categoryId değerinin veritabanındaki karşılığı
     * JPA bunu algılar ve category_id ile ilişkilendirir.
     */
    @NotNull
    private int categoryId;
}
