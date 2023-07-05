package com.wnet.dscommerce.assembler;

import com.wnet.dscommerce.dto.OrderDTO;
import com.wnet.dscommerce.entities.Order;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OrderAssembler {
    private ModelMapper modelMapper;

    public OrderDTO toModel(Order order) {
        return modelMapper.map(order, OrderDTO.class);
    }

    //qdo precisar de um List...
    public List<OrderDTO> toCollectionModel(List<Order> orders) {
        return orders.stream().map(this::toModel).collect(Collectors.toList());
    }

    //qdo precisar de um List paginado...
    public Page<OrderDTO> toCollectionModelPage(Page<Order> orders) {
        return orders.map(this::toModel);
    }

    //de DTO para Entity
    public Order toEntity(OrderDTO dto){
        return modelMapper.map(dto, Order.class);
    }
}
