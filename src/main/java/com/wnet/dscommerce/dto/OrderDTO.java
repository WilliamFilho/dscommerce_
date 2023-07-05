package com.wnet.dscommerce.dto;

import com.wnet.dscommerce.entities.Order;
import com.wnet.dscommerce.entities.OrderItem;
import com.wnet.dscommerce.entities.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private Instant moment;
    private OrderStatus status;

    private ClientDTO client;

    private PaymentDTO payment;

    private List<OrderItemDTO>  items = new ArrayList<>();

    public OrderDTO(Order order){
        this.id = order.getId();
        this.moment = order.getMoment();
        this.status = order.getStatus();
        this.client = new ClientDTO(order.getClient());
        this.payment = (order.getPayment() == null) ? null : new PaymentDTO(order.getPayment());
        for (OrderItem item: order.getItems()){
            OrderItemDTO itemDTO = new OrderItemDTO(item);
            this.items.add(itemDTO);
        }
    }

    public OrderDTO() {
    }

    public Double getTotal(){
        double sum = 0.0;
        for (OrderItemDTO item: items){
            sum += item.getSubTotal();
        }
        return sum;
    }
}
