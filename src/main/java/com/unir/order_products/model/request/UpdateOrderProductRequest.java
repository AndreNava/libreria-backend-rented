package com.unir.order_products.model.request;

import java.util.Date;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderProductRequest {
    private String ISBN;
    private String title;
    private String author;
    private String description;
    private Integer year;
    private String imageUrl;
    private String imageAlt;
    private Integer price;
    private Integer rentPriceDay;
    private Integer daysOfRent;
    private Date returnedDate;
}
