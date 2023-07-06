package com.wnet.dscommerce.assembler;

import com.wnet.dscommerce.dto.CategoryDTO;
import com.wnet.dscommerce.dto.ProductDTO;
import com.wnet.dscommerce.dto.ProductMinDTO;
import com.wnet.dscommerce.entities.Category;
import com.wnet.dscommerce.entities.Product;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class CategoryAssembler {
    private ModelMapper modelMapper;

    public CategoryDTO toModel(Category category) {
        return modelMapper.map(category, CategoryDTO.class);
    }


    //qdo precisar de um List...
    public List<CategoryDTO> toCollectionModel(List<Category> categories) {
        return categories.stream().map(this::toModel).collect(Collectors.toList());
    }

    //qdo precisar de um List paginado...
    public Page<CategoryDTO> toCollectionModelPage(Page<Category> categories) {
        return categories.map(this::toModel);
    }

    //de DTO para Entity
    public Category toEntity(CategoryDTO dto){
        return modelMapper.map(dto, Category.class);
    }
}
