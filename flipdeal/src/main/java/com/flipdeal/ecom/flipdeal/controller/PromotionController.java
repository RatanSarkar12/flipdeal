package com.flipdeal.ecom.flipdeal.controller;

import com.flipdeal.ecom.flipdeal.dto.Product;
import com.flipdeal.ecom.flipdeal.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PromotionController {

       @Autowired
       private PromotionService promotionService;


       @GetMapping("/applyProm/{promotiontype}")
       public ResponseEntity<List<Product>> applyPromotion(@PathVariable("promotiontype") String promotiontype) throws Exception {

           return new ResponseEntity<>(promotionService.applyPromotion(promotiontype),HttpStatus.OK);

       }

}
