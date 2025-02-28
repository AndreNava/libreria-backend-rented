package com.unir.order_products.model.pojo;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "order_book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class OrderProduct {

    @Id
    @Column(name = "ISBN", nullable = false, unique = true)
    private String ISBN;

    @Column(name = "title", unique = true)
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "description")
    private String description;

    @Column(name = "`year`")
    private Integer year;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Column(name = "imageAlt")
    private String imageAlt;

    @Column(name = "rentPriceDay")
    private Integer rentPriceDay;

    @Column(name = "daysOfRent")
    private Integer daysOfRent;

    @Column(name = "price")
    private Integer price;

    @Column(name = "returnedDate")
    private Date returnedDate;

}
