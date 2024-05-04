package com.flipdeal.ecom.flipdeal.strategy;

import com.flipdeal.ecom.flipdeal.Exception.ServerCustomException;
import com.flipdeal.ecom.flipdeal.constant.PromotionType;
import com.flipdeal.ecom.flipdeal.dto.DiscountDetail;
import com.flipdeal.ecom.flipdeal.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PromotionContext {
    @Autowired
    private Map<String,PromotionStrategy> promotionStrategies;

    public DiscountDetail executeStrategy(String promotionType,Product product) {
        PromotionStrategy promotionStrategy = getPromotionStrategy(promotionType);
        return promotionStrategy.CalculateDiscForGivenPromSet(product);
       // return promotionStrategies.get(promotionType).CalculateDiscForGivenPromSet(product);

    }
    private PromotionStrategy getPromotionStrategy(String promotionType){
        if(promotionStrategies.get(promotionType)==null){
            throw new ServerCustomException("No promotiontype present");
        }
        return promotionStrategies.get(promotionType);
    }
}

