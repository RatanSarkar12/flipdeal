package com.flipdeal.ecom.flipdeal.strategy;

import com.flipdeal.ecom.flipdeal.dto.DiscountDetail;
import com.flipdeal.ecom.flipdeal.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("PROMOTION_SET_A")
public class PromotionStrategyA implements PromotionStrategy{
    @Override
    public DiscountDetail CalculateDiscForGivenPromSet(Product product) {

         DiscountDetail discountDetail = new DiscountDetail();
         int max_discount=Integer.MIN_VALUE;
         String discountTag="";
        if(product.getOrigin().equals("africa")){

          max_discount=Math.max( max_discount,(product.getPrice()*7/100));
           discountTag =  "discount applied 7%";

        }
        if(product.getRating()==2) {
            max_discount=Math.max( max_discount,(product.getPrice()*4/100));

            discountTag = "discount applied 4%";
        }
       else if(product.getRating()>2) {

            max_discount=Math.max( max_discount,(product.getPrice()*8/100));

            discountTag = "discount applied 8%";
        }
        if(product.getCategory().equals("electronics") || product.getCategory().equals("furnishing")) {
            max_discount=Math.max( max_discount,100);
            discountTag = "discount applied rs 100";
        }
        discountDetail.setAmount(max_discount);
        discountDetail.setDiscountTag(discountTag);
        return discountDetail;
    }
}
