package com.wnet.dscommerce.services;

import com.wnet.dscommerce.assembler.OrderAssembler;
import com.wnet.dscommerce.dto.OrderDTO;
import com.wnet.dscommerce.repositories.OrderRepository;
import com.wnet.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;
    @Autowired
    private OrderAssembler assembler;
    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        return repository.findById(id).map(order -> new OrderDTO(order)).orElseThrow(()-> new ResourceNotFoundException("Recurso não encontrado!"));
    }
}
