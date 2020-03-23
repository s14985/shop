package com.tin.shop.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Material name is required.")
    @Basic(optional = false)
    private String name;

    public Material(@NotNull(message = "Material name is required.") String name) {
        this.name = name;
    }

    public Material() {
    }
}
