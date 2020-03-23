package com.tin.shop.controller;

import com.tin.shop.model.Material;
import com.tin.shop.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/materials")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @GetMapping({"", "/"})
    public @NotNull Iterable<Material> getMaterial() {
        return materialService.getAllMaterials();
    }
}
