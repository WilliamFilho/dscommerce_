package com.wnet.dscommerce.assembler;

import com.wnet.dscommerce.dto.ProductDTO;
import com.wnet.dscommerce.entities.Product;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class ProductAssembler {
    private ModelMapper modelMapper;

    public ProductDTO toModel(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }

    public List<ProductDTO> toCollectionModel(List<Product> products) {
        return products.stream().map(this::toModel).collect(Collectors.toList());
    }

    public Page<ProductDTO> toCollectionModel(Page<Product> products) {
        return products.map(this::toModel);
    }

    public Product toEntity(ProductDTO dto){
        return modelMapper.map(dto, Product.class);
    }
}
