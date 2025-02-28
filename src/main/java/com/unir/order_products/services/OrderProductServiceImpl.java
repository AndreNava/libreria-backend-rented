package com.unir.order_products.services;

import com.unir.order_products.data.OrderProductsRepository;
import com.unir.order_products.model.pojo.OrderProduct;
import com.unir.order_products.model.request.CreateOrderProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class OrderProductServiceImpl implements OrderProductService{

    @Autowired
    private OrderProductsRepository repository;

    @Override
    public List<OrderProduct> getProducts() {
        List<OrderProduct> products = repository.findAll();
        return products.isEmpty() ? null : products;
    }

    @Override
    public OrderProduct getProduct(String productId) {
        return repository.findByISBN(productId)
                .stream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public OrderProduct createOrderProduct(CreateOrderProductRequest request) {
        if (request != null && request.getISBN() != null) {
            OrderProduct product = OrderProduct.builder()
                    .ISBN(request.getISBN())
                    .title(request.getTitle())
                    .author(request.getAuthor())
                    .description(request.getDescription())
                    .year(request.getYear())
                    .imageUrl(request.getImageUrl())
                    .imageAlt(request.getImageAlt())
                    .rentPriceDay(request.getRentPriceDay())
                    .daysOfRent(request.getDaysOfRent())
                    .price(request.getPrice())
                    .returnedDate(request.getReturnedDate())
                    .build();

            return repository.save(product);
        } else {
            return null;
        }
    }

}
