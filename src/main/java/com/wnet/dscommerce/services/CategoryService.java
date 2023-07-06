package com.wnet.dscommerce.services;

import com.wnet.dscommerce.assembler.CategoryAssembler;
import com.wnet.dscommerce.dto.CategoryDTO;
import com.wnet.dscommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;
    @Autowired
    private CategoryAssembler assembler;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        return assembler.toCollectionModel(repository.findAll());
    }
}
