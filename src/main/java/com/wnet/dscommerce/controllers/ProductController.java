package com.wnet.dscommerce.controllers;

import com.wnet.dscommerce.assembler.ProductAssembler;
import com.wnet.dscommerce.dto.ProductDTO;
import com.wnet.dscommerce.entities.Product;
import com.wnet.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    private ProductAssembler assembler;

    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable Long id){
        return service.findById(id);
    }

    //Paginação /products?size=1&page=1&sort=name
    @GetMapping
    public Page<ProductDTO> findAll(Pageable pageable){
        return service.findAll(pageable);
    }

    /*
    @PostMapping
    public ProductDTO create(@RequestBody ProductDTO dto){
        Product newProduct = assembler.toEntity(dto);
        Product saveProduct = service.insert(newProduct);
        return assembler.toModel(saveProduct);
    }
     */

    @PostMapping
    public ProductDTO create(@RequestBody ProductDTO dto){
        return service.insert(dto);
    }

}
