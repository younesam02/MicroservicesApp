package org.example.microservicecommande.controllers;

import org.example.microservicecommande.entities.Commande;
import org.example.microservicecommande.feign.ProduitFeignClient;
import org.example.microservicecommande.repositories.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/commandes")
@RefreshScope  // So we can refresh config at runtime (Étude de cas 1 feature)
public class CommandeController {

    @Autowired
    private CommandeRepository commandeRepository;

    @Autowired
    private Environment env;

    @Autowired
    private ProduitFeignClient produitFeignClient;

    @GetMapping
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Commande getCommandeById(@PathVariable Long id) {
        return commandeRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Commande createCommande(@RequestBody Commande commande) {
        // Ensure default date if not provided
        if (commande.getDate() == null) {
            commande.setDate(LocalDate.now());
        }

        // Validate each product ID
        if (commande.getProduitsIds() != null && !commande.getProduitsIds().isEmpty()) {
            for (Long productId : commande.getProduitsIds()) {
                Object produit = produitFeignClient.getProduitById(productId);
                if (produit == null) {
                    // If fallback triggers or product doesn't exist
                    throw new RuntimeException("Produit avec ID=" + productId + " introuvable ou fallback déclenché.");
                }
            }
        }

        // Save in DB
        return commandeRepository.save(commande);
    }

    @PutMapping("/{id}")
    public Commande updateCommande(@PathVariable Long id, @RequestBody Commande updatedCommande) {
        return commandeRepository.findById(id).map(cmd -> {
            cmd.setDescription(updatedCommande.getDescription());
            cmd.setQuantite(updatedCommande.getQuantite());
            cmd.setDate(updatedCommande.getDate());
            cmd.setMontant(updatedCommande.getMontant());
            cmd.setProduitsIds(updatedCommande.getProduitsIds()); // Updated product IDs
            return commandeRepository.save(cmd);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteCommande(@PathVariable Long id) {
        commandeRepository.deleteById(id);
    }

    // Reading custom config property from Spring Cloud Config (Étude de cas 1)
    @GetMapping("/config/last-days")
    public String getConfigLastDays() {
        return env.getProperty("mes-config-ms.commandes-last", "not found");
    }
}
