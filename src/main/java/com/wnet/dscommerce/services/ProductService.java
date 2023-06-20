package com.wnet.dscommerce.services;

import com.wnet.dscommerce.assembler.ProductAssembler;
import com.wnet.dscommerce.dto.ProductDTO;
import com.wnet.dscommerce.entities.Product;
import com.wnet.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private ProductAssembler assembler;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        return repository.findById(id).map(product -> assembler.toModel(product)).orElse(null);
    }
}
