package org.example.microservicecommande.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// microservice-produit is typically named MICROSERVICE-PRODUIT in Eureka
@FeignClient(name = "Produit", fallback = ProduitFeignFallback.class)
public interface ProduitFeignClient {
    @GetMapping("/api/produits/{id}")
    Object getProduitById(@PathVariable("id") Long id);
}