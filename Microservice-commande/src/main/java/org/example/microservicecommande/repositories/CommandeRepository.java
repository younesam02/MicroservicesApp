package org.example.microservicecommande.repositories;

import org.example.microservicecommande.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
