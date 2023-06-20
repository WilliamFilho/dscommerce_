package com.wnet.dscommerce.dto;

import com.wnet.dscommerce.entities.Product;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;

    //Alternativa cabulosa
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
