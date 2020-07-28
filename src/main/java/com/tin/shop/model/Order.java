package com.tin.shop.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "orderProducts")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateCreated;

    private String status;

    @JsonIgnore
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "pk.order")
    @Valid
    private List<OrderProduct> orderProducts = new ArrayList<>();

    @Transient
    public Double getTotalOrderPrice() {
        List<OrderProduct> orderProducts = getOrderProducts();
        return orderProducts.stream().map(OrderProduct::getTotalPrice).reduce(Double::sum).get();
    }

    @Transient
    public int getNumberOfProducts() {
        return this.orderProducts.size();
    }
}
