package com.flipdeal.ecom.flipdeal.strategy;

import com.flipdeal.ecom.flipdeal.dto.DiscountDetail;
import com.flipdeal.ecom.flipdeal.dto.Product;

public interface PromotionStrategy {

    public DiscountDetail CalculateDiscForGivenPromSet(Product product);
}

