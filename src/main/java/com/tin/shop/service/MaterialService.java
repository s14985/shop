package com.tin.shop.service;

import com.tin.shop.model.Material;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Validated
public interface MaterialService {

    @NotNull Iterable<Material> getAllMaterials();

    Material getMaterialById(@Min(value = 1L, message = "Invalid material ID.") long id);

    Material save (Material material);
}
