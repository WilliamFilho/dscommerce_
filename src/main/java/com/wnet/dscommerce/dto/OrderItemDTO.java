package com.wnet.dscommerce.dto;

import com.wnet.dscommerce.entities.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderItemDTO {
    private Long productId;
    private String name;
    private Double price;
    private Integer quantity;

    private String imgURL;

    public OrderItemDTO(OrderItem orderItem){
        productId = orderItem.getProduct().getId();
        name = orderItem.getProduct().getName();
        price = orderItem.getPrice();
        quantity = orderItem.getQuantity();
        imgURL = orderItem.getProduct().getImgUrl();
    }

    public Double getSubTotal(){
        return price * quantity;
    }
}
