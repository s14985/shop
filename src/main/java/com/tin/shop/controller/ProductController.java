package com.tin.shop.controller;

import com.tin.shop.exception.ResourceNotFoundException;
import com.tin.shop.model.Product;
import com.tin.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping({"", "/"})
    public @NotNull Iterable<Product> getProducts() {
        return productService.getAllProducts();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public @NotNull Product getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @PostMapping()
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
        this.productService.save(product);
        String uri = ServletUriComponentsBuilder
                .fromCurrentServletMapping()
                .path("/products/{id}")
                .buildAndExpand(product.getId())
                .toString();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", uri);

        return new ResponseEntity<>(product, headers, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        try {
            this.productService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Product not found");
        }
    }

    @GetMapping("/material/{material}")
    public Iterable<Product> getProducts(@PathVariable String material) {
        return productService.getAllByMaterial(material);
    }
}
