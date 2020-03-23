package com.tin.shop.repository;

import com.tin.shop.model.Material;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MaterialRepository extends CrudRepository<Material, Long> {
    Material getById(Long id);
}
