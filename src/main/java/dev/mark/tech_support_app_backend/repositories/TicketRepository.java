package dev.mark.tech_support_app_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.mark.tech_support_app_backend.models.Ticket;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    
}

