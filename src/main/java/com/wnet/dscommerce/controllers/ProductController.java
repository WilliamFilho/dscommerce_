package com.wnet.dscommerce.controllers;

import com.wnet.dscommerce.dto.ProductDTO;
import com.wnet.dscommerce.entities.Product;
import com.wnet.dscommerce.repositories.ProductRepository;
import com.wnet.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/{id}")
    public ProductDTO findById(@PathVariable Long id){
        return service.findById(id);
    }
}
