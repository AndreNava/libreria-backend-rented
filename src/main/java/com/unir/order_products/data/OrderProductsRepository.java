package com.unir.order_products.data;

import com.unir.order_products.model.pojo.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderProductsRepository extends JpaRepository<OrderProduct, String> {
    List<OrderProduct> findByISBN(String ISBN);
}
