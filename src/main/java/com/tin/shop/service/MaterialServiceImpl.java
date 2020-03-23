package com.tin.shop.service;

import com.tin.shop.model.Material;
import com.tin.shop.repository.MaterialRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Slf4j
@Service
@Transactional
public class MaterialServiceImpl implements MaterialService {

    MaterialRepository materialRepository;

    public MaterialServiceImpl(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Override
    public @NotNull Iterable<Material> getAllMaterials() {
        return materialRepository.findAll();
    }

    @Override
    public Material getMaterialById(@Min(value = 1L, message = "Invalid material ID.") long id) {
        return materialRepository.getById(id);
    }

    @Override
    public Material save(Material material) {
        return materialRepository.save(material);
    }
}
