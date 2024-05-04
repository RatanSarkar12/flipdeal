package com.flipdeal.ecom.flipdeal.strategy;

import com.flipdeal.ecom.flipdeal.dto.DiscountDetail;
import com.flipdeal.ecom.flipdeal.dto.Product;
import org.springframework.stereotype.Component;

@Component("PROMOTION_SET_B")
public class PromotionStrategyB implements PromotionStrategy{

    @Override
    public DiscountDetail CalculateDiscForGivenPromSet(Product product) {

         DiscountDetail discountDetail = new DiscountDetail();
        int max_disc=Integer.MIN_VALUE;
        String discTag="";
         if(product.getInventory()>20){
             max_disc=Math.max(max_disc,product.getPrice()*12/100);
             discTag = "applied 12";
         }
         if(product.getArrival()=="new"){
             max_disc=Math.max(max_disc,product.getPrice()*7/100);
             discTag = "applied 7";
         }
             discountDetail.setAmount(max_disc);
             discountDetail.setDiscountTag(discTag);
             return discountDetail;
    }
}
