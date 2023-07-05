package com.wnet.dscommerce.dto;

import com.wnet.dscommerce.entities.Order;
import com.wnet.dscommerce.entities.OrderItem;
import com.wnet.dscommerce.entities.OrderStatus;
import lombok.Data;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDTO {
    private Long id;
    private Instant moment;
    private OrderStatus status;

    private ClientDTO client;

    private PaymentDTO payment;

    private List<OrderItemDTO>  items = new ArrayList<>();

    public OrderDTO(Order order){
        id = order.getId();
        moment = order.getMoment();
        status = order.getStatus();
        client = new ClientDTO(order.getClient());
        payment = (order.getPayment() == null) ? null : new PaymentDTO(order.getPayment());
        for (OrderItem item: order.getItems()){
            OrderItemDTO itemDTO = new OrderItemDTO(item);
            items.add(itemDTO);
        }
    }

    public Double getTotal(){
        double sum = 0.0;
        for (OrderItemDTO item: items){
            sum += item.getSubTotal();
        }
        return sum;
    }
}
