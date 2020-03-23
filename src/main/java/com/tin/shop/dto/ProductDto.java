package com.tin.shop.dto;

import com.tin.shop.model.Material;
import lombok.Data;

@Data
public class ProductDto {

    private String name;

    private String description;

    private Double price;

    private String pictureUrl;

    private String details;

    private Material material;
}
