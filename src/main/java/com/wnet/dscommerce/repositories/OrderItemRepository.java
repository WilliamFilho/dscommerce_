package com.wnet.dscommerce.repositories;

import com.wnet.dscommerce.entities.Order;
import com.wnet.dscommerce.entities.OrderItem;
import com.wnet.dscommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
