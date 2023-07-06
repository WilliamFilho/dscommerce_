package com.wnet.dscommerce.services;

import com.wnet.dscommerce.dto.OrderDTO;
import com.wnet.dscommerce.dto.OrderItemDTO;
import com.wnet.dscommerce.entities.*;
import com.wnet.dscommerce.repositories.OrderItemRepository;
import com.wnet.dscommerce.repositories.OrderRepository;
import com.wnet.dscommerce.repositories.ProductRepository;
import com.wnet.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
       return repository.findById(id).map(order -> new OrderDTO(order)).orElseThrow(()-> new ResourceNotFoundException("Recurso não encontrado!"));
    }

    @Transactional
    public OrderDTO insert(OrderDTO dto) {
        Order order = new Order();
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);

        User user = userService.authenticated();
        order.setClient(user);

        for (OrderItemDTO itemDTO: dto.getItems()){
            Product product = productRepository.getReferenceById(itemDTO.getProductId());
            OrderItem item = new OrderItem(order, product, itemDTO.getQuantity(), product.getPrice());
            order.getItems().add(item);
        }
        repository.save(order);
        orderItemRepository.saveAll(order.getItems());

        return new OrderDTO(order);
    }
}
