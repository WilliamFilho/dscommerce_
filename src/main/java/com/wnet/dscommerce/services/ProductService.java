package com.wnet.dscommerce.services;

import com.wnet.dscommerce.assembler.ProductAssembler;
import com.wnet.dscommerce.dto.ProductDTO;
import com.wnet.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        return assembler.toCollectionModel(repository.findAll(pageable));
    }
}
