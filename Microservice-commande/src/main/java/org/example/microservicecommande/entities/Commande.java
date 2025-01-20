package org.example.microservicecommande.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private int quantite;
    private LocalDate date;
    private double montant;

    // Instead of a single "idProduit", store multiple product IDs:
    @ElementCollection
    private List<Long> produitsIds = new ArrayList<>();

    // Constructors
    public Commande() {
    }

    public Commande(String description, int quantite, LocalDate date, double montant, List<Long> produitsIds) {
        this.description = description;
        this.quantite = quantite;
        this.date = date;
        this.montant = montant;
        this.produitsIds = produitsIds;
    }

    // Getters / Setters

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantite() {
        return quantite;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getMontant() {
        return montant;
    }

    public List<Long> getProduitsIds() {
        return produitsIds;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setProduitsIds(List<Long> produitsIds) {
        this.produitsIds = produitsIds;
    }
}
