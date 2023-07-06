package com.wnet.dscommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class ProductDTO {
    private Long id;

    @Size(min = 3, max = 80, message = "Nome de 3 a 80 caracteres!")
    @NotBlank(message = "Campo requerido!")
    private String name;

    @Size(min = 10, message = "Mínimo 10 caracteres!")
    @NotBlank(message = "Campo requerido!")
    private String description;

    @NotNull(message = "Campo requerido!")
    @Positive
    private Double price;
    private String imgUrl;

    List<CategoryDTO> categories = new ArrayList<>();

    public void addCategory(CategoryDTO categoryDTO){
        categories.add(categoryDTO);
    }
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
