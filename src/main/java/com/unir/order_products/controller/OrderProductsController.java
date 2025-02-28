package com.unir.order_products.controller;

import com.unir.order_products.model.pojo.OrderProduct;
import com.unir.order_products.model.request.CreateOrderProductRequest;
import com.unir.order_products.services.OrderProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OrderProductsController {

    private final OrderProductService service;

    @GetMapping("/order-products")
    public ResponseEntity<List<OrderProduct>> getProducts(@RequestHeader Map<String, String> headers) {
        log.info("headers: {}", headers);
        List<OrderProduct> products = service.getProducts();
        return products != null ? ResponseEntity.ok(products) : ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping("/order-products/{productId}")
    public ResponseEntity<OrderProduct> getProduct(@PathVariable String productId) {
        log.info("Request received for product {}", productId);
        OrderProduct product = service.getProduct(productId);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

    @PostMapping("/order-products")
    public ResponseEntity<OrderProduct> createProduct(@RequestBody CreateOrderProductRequest request) {
        OrderProduct createdOrderProduct = service.createOrderProduct(request);
        if (createdOrderProduct != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderProduct);
        } else {
            return ResponseEntity.badRequest ().build();
        }
    }

}
