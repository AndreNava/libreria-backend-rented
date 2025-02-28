package com.unir.order_products.services;

import com.unir.order_products.model.pojo.OrderProduct;
import com.unir.order_products.model.request.CreateOrderProductRequest;
import java.util.List;

public interface OrderProductService {
    List<OrderProduct> getProducts();
    OrderProduct getProduct(String ISBN);
    OrderProduct createOrderProduct(CreateOrderProductRequest request);
}
