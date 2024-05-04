package com.flipdeal.ecom.flipdeal.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
//public class Product {
//    private String category;
//    private int inventory;
//    private int rating;
//    private String currency;
//    private int price;
//    private String origin;
//    private String product;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    private String category;
    private int inventory;
    private double rating;
    private String currency;
    private int price;
    private String origin;
    private String product;
    private String arrival;
    private DiscountDetail discount;
}