package org.example.produit.reposetories;

import org.example.produit.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<org.example.produit.entities.Produit, Long> {
}
