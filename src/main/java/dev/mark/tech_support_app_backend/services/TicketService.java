package dev.mark.tech_support_app_backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.mark.tech_support_app_backend.exceptions.TicketNotFoundException;
import dev.mark.tech_support_app_backend.messages.Message;
import dev.mark.tech_support_app_backend.models.Ticket;
import dev.mark.tech_support_app_backend.repositories.TicketRepository;


@Service
public class TicketService implements IGenericService<Ticket> {
    
    TicketRepository repository;

    public TicketService(TicketRepository repository) {
        this.repository = repository;
    }

    public List<Ticket> getAll() {
        List<Ticket> tickets = repository.findAll();
        return tickets;
    }

    public Ticket getById(Long id) throws Exception {
        Ticket ticket = repository.findById(id).orElseThrow(() -> new TicketNotFoundException("Ticket not found"));

        return ticket;
    }

    public Ticket save(Ticket ticket) {
        
        Ticket newTicket = repository.save(ticket);
        return newTicket;
    }

    public Ticket update(Long id, Ticket ticket) throws Exception {
        
        Ticket updatingUser = repository.findById(id).orElseThrow(() -> new TicketNotFoundException("Ticket not found"));
        
        updatingUser.setProblem_type(ticket.getProblem_type());
        updatingUser.setDescription(ticket.getDescription());
        updatingUser.setStatus(ticket.getStatus());

        Ticket updatedTicket = repository.save(updatingUser);
        
        return updatedTicket;
    }

    public Message delete(Long id) throws Exception {
        
        Ticket ticket = repository.findById(id).orElseThrow(() -> new TicketNotFoundException("Ticket not found"));

        Long ticketId = ticket.getId();

        repository.delete(ticket);

        Message message = new Message();

        message.setMessage("Ticket number " + ticketId + " is deleted from the movies table");

        return message;
    }
}
