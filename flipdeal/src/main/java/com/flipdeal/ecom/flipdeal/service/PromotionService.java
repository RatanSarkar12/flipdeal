package com.flipdeal.ecom.flipdeal.service;

import com.flipdeal.ecom.flipdeal.client.FlipDealClient;
import com.flipdeal.ecom.flipdeal.dto.DiscountDetail;
import com.flipdeal.ecom.flipdeal.dto.Product;
import com.flipdeal.ecom.flipdeal.strategy.PromotionContext;
import com.flipdeal.ecom.flipdeal.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java .util.List;
import java.util.Map;

@Service
public class PromotionService {
    @Autowired
    private FlipDealClient flipDealClient;

    @Autowired
    PromotionContext promotionContext;


    public List<Product> applyPromotion(String promotiontype)throws Exception{

        List<Product>products = flipDealClient.fetchProductDetails();

        Map<String,Object>exchangeCurrencies = FlipDealClient.fetchCurrencyExchange();

        List<Product>updatedProducts = Common.ChangeCurrencyToInr(exchangeCurrencies,products);

        for(Product updatedProduct:updatedProducts){
           DiscountDetail discountDetail = promotionContext.executeStrategy(promotiontype,updatedProduct);
           updatedProduct.setDiscount(discountDetail);
        }
        return updatedProducts;


    }


}
