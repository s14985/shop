package com.tin.shop.controller;

import com.tin.shop.model.Product;
import com.tin.shop.model.User;
import com.tin.shop.service.SuggestedProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/suggest")
public class SuggestedProductsController {

    private SuggestedProductsService suggestedProductsService;

    @Autowired
    public SuggestedProductsController(SuggestedProductsService suggestedProductsService) {
        this.suggestedProductsService = suggestedProductsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getSuggestedProducts(@PathVariable Long id) {
        return ResponseEntity.ok(suggestedProductsService.getSuggestedProducts(id));
    }
}
