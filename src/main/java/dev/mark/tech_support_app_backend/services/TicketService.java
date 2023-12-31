package dev.mark.tech_support_app_backend.services;

import java.util.List;
import org.springframework.stereotype.Service;

import dev.mark.tech_support_app_backend.exceptions.TicketNotFoundException;
import dev.mark.tech_support_app_backend.exceptions.UserNotFoundException;
import dev.mark.tech_support_app_backend.messages.Message;
import dev.mark.tech_support_app_backend.models.Ticket;
import dev.mark.tech_support_app_backend.models.User;
import dev.mark.tech_support_app_backend.repositories.TicketRepository;
import dev.mark.tech_support_app_backend.repositories.UserRepository;


@Service
public class TicketService implements IGenericService<Ticket> {
    
    TicketRepository repository;
    UserRepository userRepository;

    public TicketService(TicketRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public List<Ticket> getAll() {
        List<Ticket> tickets = repository.findAll();
        return tickets;
    }

    public Ticket getById(Long id) throws Exception {
        Ticket ticket = repository.findById(id).orElseThrow(() -> new TicketNotFoundException("Ticket not found"));

        return ticket;
    }

    // public Ticket save(Ticket ticket) {
        
    //     Ticket newTicket = repository.save(ticket);
    //     return newTicket;
    // }

    public Ticket save(Ticket newTicket) {
        // find the user
        User user = userRepository.findById(newTicket.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        // associate the ticket with the user
        newTicket.setUser(user);

        // save the ticket

        repository.save(newTicket);
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

        message.setMessage("Ticket number " + ticketId + " is deleted from the tickets table");

        return message;
    }
}
