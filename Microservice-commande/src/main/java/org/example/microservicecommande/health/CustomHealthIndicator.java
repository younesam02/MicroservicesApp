package org.example.microservicecommande.health;

import org.example.microservicecommande.repositories.CommandeRepository;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    private final CommandeRepository commandeRepository;

    public CustomHealthIndicator(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    @Override
    public Health health() {
        long count = commandeRepository.count();
        if (count > 0) {
            return Health.up().withDetail("message", "There are " + count + " commandes").build();
        } else {
            return Health.down().withDetail("message", "No commandes found").build();
        }
    }
}

