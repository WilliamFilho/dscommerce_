package com.wnet.dscommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class ProductMinDTO {
    private Long id;
    private String name;
    private Double price;
    private String imgUrl;

    @NotEmpty(message = "Deve conter pelo menos uma (1) categoria")
    private List<CategoryDTO> categories = new ArrayList<>();


    //Alternativa
    /*
    public ProductDTO(Product entity){
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        price = entity.getPrice();
        imgUrl = entity.getImgUrl();
    }
     */

}
