package com.tin.shop.service;

import com.tin.shop.model.Order;
import com.tin.shop.model.OrderProduct;
import com.tin.shop.model.Product;
import com.tin.shop.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SuggestedProductsService {

    private UserServiceImpl userService;
    private OrderServiceImpl orderService;
    private OrderProductServiceImpl orderProductService;
    private ProductServiceImpl productService;

    public SuggestedProductsService(
            UserServiceImpl userService,
            OrderServiceImpl orderService,
            OrderProductServiceImpl orderProductService,
            ProductServiceImpl productService
    ) {
        this.userService = userService;
        this.orderService = orderService;
        this.orderProductService = orderProductService;
        this.productService = productService;
    }

    public Product getSuggestedProducts(Long productId) {
        User user = userService.getCurrentUser();
        Iterable<Order> userOrders = orderService.getUserOrders(user.getId());
        Map<Product, Integer> productMap = new HashMap<>();

        for (Order order : userOrders) {
            Iterable<OrderProduct> orderProducts = orderProductService.getAllByOrder(order);
            for (OrderProduct orderProduct : orderProducts) {
                if(orderProduct.getProduct().getId().equals(productId)) {
                    User user1 = orderProduct.getPk().getOrder().getUser();
                    Iterable<Order> userOrders1 = orderService.getUserOrders(user1.getId());
                    for (Order order1 : userOrders1) {
                        Iterable<OrderProduct> orderProducts1 = orderProductService.getAllByOrder(order1);
                        for (OrderProduct orderProduct1 : orderProducts1) {
                           if (productMap.containsKey(orderProduct1.getProduct())) {
                               productMap.replace(
                                       orderProduct1.getProduct(),
                                       productMap.get(orderProduct1.getProduct()),
                                       productMap.get(orderProduct1.getProduct()) + 1
                               );
                           } else {
                               productMap.put(orderProduct1.getProduct(), 1);
                           }
                        }
                    }
                }

            }
        }
        return maxUsingCollectionsMax(productMap);
    }

    private  <K, V extends Comparable<V>> K maxUsingCollectionsMax(Map<K, V> map) {
        Map.Entry<K, V> maxEntry = Collections.max(map.entrySet(), Comparator.comparing(Map.Entry::getValue));
        return maxEntry.getKey();
    }
}
