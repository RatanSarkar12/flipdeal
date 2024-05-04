package com.flipdeal.ecom.flipdeal.utils;

import com.flipdeal.ecom.flipdeal.constant.Currency;
import com.flipdeal.ecom.flipdeal.dto.Product;

//import java.util.Currency;
import java.util.List;
import java.util.Map;

import static com.flipdeal.ecom.flipdeal.constant.Currency.INR;

public class Common {

    public static List<Product> ChangeCurrencyToInr(Map<String,Object>exchangedCurrencies, List<Product>products){

            for(Product product:products){
                if(!INR.name().equals(product.getCurrency())){
                    product.setPrice((int)(product.getPrice()*(double)exchangedCurrencies.get(product.getCurrency())));
                    product.setCurrency(Currency.INR.name());
                }
            }
            return products;
    }
}
