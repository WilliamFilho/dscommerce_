package com.wnet.dscommerce.services;

import com.wnet.dscommerce.assembler.ProductAssembler;
import com.wnet.dscommerce.dto.ProductDTO;
import com.wnet.dscommerce.entities.Product;
import com.wnet.dscommerce.repositories.ProductRepository;
import com.wnet.dscommerce.services.exceptions.DatabaseException;
import com.wnet.dscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    Passo para o Controller a responsabilidade de fornecer código de erro adequado.
    */
    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        return repository.findById(id).map(product -> assembler.toModel(product)).orElseThrow(()-> new ResourceNotFoundException("Recurso não encontrado!"));
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(String name, Pageable pageable) {
        return assembler.toCollectionModelPage(repository.findByNameContainingIgnoreCase(name, pageable));
    }

    /*
    @Transactional
    public Product insert(Product product) {fs
        return repository.save(product);
    }
    */
    @Transactional
    public ProductDTO insert(ProductDTO dto) { //já envio convertido (DTO)
        Product newProduct = assembler.toEntity(dto);
        repository.save(newProduct);
        return assembler.toModel(newProduct);
    }

    @Transactional
    public ProductDTO uptade(Long id, ProductDTO dto) { //já envio convertido (DTO)
        return repository.findById(id).map(product ->  {
            product = assembler.toEntity(dto);
            product.setId(id);
            repository.save(product);
            return assembler.toModel(product);
        }).orElseThrow(()-> new EntityNotFoundException("Recurso não encontrado!"));
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        try {
            //if(!repository.existsById(id));
            repository.deleteById(id);
        }catch (DataIntegrityViolationException e){
                throw new DatabaseException("Falha na Integridade Referencial!");
        }
    }
}

/*
    @Transactional
    public Cliente salvar(Cliente cliente){
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail()).stream().anyMatch(c -> !c.equals(cliente));
        if (emailEmUso){
            throw new NegocioException("Já existe um cliente cadastrado com este e-mail!");
        }
        return clienteRepository.save(cliente);
    }
 */