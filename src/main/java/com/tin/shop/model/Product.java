package com.tin.shop.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Product name is required.")
    @Basic(optional = false)
    private String name;

    private String description;

    private Double price;

    private String pictureUrl;

    private String details;

    @JoinColumn(name = "material_id")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Material material;

    public Product(@NotNull(message = "Product name is required.") String name, String description, Double price, String pictureUrl, String details, Material material) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.pictureUrl = pictureUrl;
        this.details = details;
        this.material = material;
    }

    public Product() {
    }
}
