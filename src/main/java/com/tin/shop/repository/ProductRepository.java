package com.tin.shop.repository;

import com.tin.shop.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    Iterable<Product> getAllByMaterial(String material);
}
