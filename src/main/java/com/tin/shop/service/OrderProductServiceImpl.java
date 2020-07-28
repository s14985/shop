package com.tin.shop.service;

import com.tin.shop.model.Order;
import com.tin.shop.model.OrderProduct;
import com.tin.shop.model.Product;
import com.tin.shop.repository.OrderProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderProductServiceImpl implements OrderProductService {

    private OrderProductRepository orderProductRepository;

    public OrderProductServiceImpl(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    @Override
    public OrderProduct create(OrderProduct orderProduct) {
        return this.orderProductRepository.save(orderProduct);
    }

    @Override
    public Iterable<OrderProduct> getAllByProduct(Product product) {
        return this.orderProductRepository.findAllByPkProduct(product);
    }

    @Override
    public Iterable<OrderProduct> getAllByOrder(Order order) {
        return this.orderProductRepository.findAllByPkOrder(order);
    }
}
