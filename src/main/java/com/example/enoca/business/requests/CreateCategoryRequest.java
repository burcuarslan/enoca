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
public class CreateCategoryRequest {

    @NotNull
    @NotBlank
    @Size(min = 3, max = 50)
    private String categoryName;
}
