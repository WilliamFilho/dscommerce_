package com.wnet.dscommerce.dto;

import com.wnet.dscommerce.entities.User;
import lombok.Data;

@Data
public class ClientDTO {
    private Long id;
    private String name;

    public ClientDTO(User user){
        id = user.getId();
        name = user.getName();
    }
}
