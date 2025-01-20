package org.example.produit.controllers;

import org.example.produit.entities.Produit;
import org.example.produit.reposetories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    @GetMapping("/{id}")
    public Produit getProduitById(@PathVariable Long id) {
        return produitRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Produit createProduit(@RequestBody Produit produit) {
        return produitRepository.save(produit);
    }

    @PutMapping("/{id}")
    public Produit updateProduit(@PathVariable Long id, @RequestBody Produit updatedProduit) {
        return produitRepository.findById(id).map(prod -> {
            prod.setNom(updatedProduit.getNom());
            prod.setPrix(updatedProduit.getPrix());
            return produitRepository.save(prod);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteProduit(@PathVariable Long id) {
        produitRepository.deleteById(id);
    }
}
