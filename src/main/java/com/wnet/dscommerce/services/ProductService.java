package com.wnet.dscommerce.services;

import com.wnet.dscommerce.assembler.ProductAssembler;
import com.wnet.dscommerce.dto.ProductDTO;
import com.wnet.dscommerce.entities.Product;
import com.wnet.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    @Autowired
    private ProductAssembler assembler;

    /*
    @Transactional(readOnly = true) //Serviço não deve conhecer/fornecer HTTP
    public ResponseEntity<ProductDTO> findById(Long id) {
        return repository.findById(id).map(product -> ResponseEntity.ok(assembler.toModel(product))).orElse(ResponseEntity.notFound().build());
    }

    //Passo para o Controller a responsabilidade de fornecer código de erro adequado.
    */@Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        return repository.findById(id).map(product -> assembler.toModel(product)).orElse(null);
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        return assembler.toCollectionModel(repository.findAll(pageable));
    }

    /*
    @Transactional
    public Product insert(Product product) {
        return repository.save(product);
    }
    */
    @Transactional
    public ProductDTO insert(ProductDTO dto) { //já envio convertido (DTO)
        Product newProduct = assembler.toEntity(dto);
        repository.save(newProduct);
        return assembler.toModel(newProduct);
    }

}
