package org.example.microservicecommande.feign;

import org.springframework.stereotype.Component;

@Component
public class ProduitFeignFallback implements ProduitFeignClient {

    @Override
    public Object getProduitById(Long id) {
        // Return null or a default object in case of
        return null;
    }
}