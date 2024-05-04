package com.flipdeal.ecom.flipdeal.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipdeal.ecom.flipdeal.dto.Product;
import com.flipdeal.ecom.flipdeal.utils.HttpCaller;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FlipDealClient {

       public List<Product> fetchProductDetails() throws IOException {

             String response =  HttpCaller.get("https://mock.coverself.net/rest/hiring/products",null);
             ObjectMapper objectMapper = new ObjectMapper();
             List<Product> products = objectMapper.readValue(response,objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class));
             return products;
       }
       public static Map<String,Object> fetchCurrencyExchange() throws IOException {

        String response =  HttpCaller.get("https://mock.coverself.net/rest/hiring/exchange-rates",null);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object>hm = objectMapper.readValue(response,HashMap.class);//get("rates");
        Map<String,Object>map = (Map<String, Object>) hm.get("rates");
        return map;
    }

}
