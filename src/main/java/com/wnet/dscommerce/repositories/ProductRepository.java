package com.wnet.dscommerce.repositories;

import com.wnet.dscommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //@Query("FROM Product obj WHERE UPPER(obj.name) LIKE UPPER(CONCAT('%',:name, '%'))")
    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
