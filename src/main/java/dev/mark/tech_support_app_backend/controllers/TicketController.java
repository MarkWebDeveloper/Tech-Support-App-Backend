package dev.mark.tech_support_app_backend.controllers;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.mark.tech_support_app_backend.messages.Message;
import dev.mark.tech_support_app_backend.models.Ticket;
import dev.mark.tech_support_app_backend.services.IGenericService;
import dev.mark.tech_support_app_backend.services.TicketService;

@RestController
@RequestMapping(path = "${api-endpoint}/tickets")
public class TicketController {

    IGenericService<Ticket> service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public List<Ticket> index() {

        List<Ticket> tickets = service.getAll();
        return tickets;

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Ticket> show(@PathVariable("id") Long id) throws Exception {

        Ticket ticket = service.getById(id);

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(ticket);
    }

    @PostMapping(path = "")
    public ResponseEntity<Ticket> create(@RequestBody Ticket ticket) {

        Ticket newUser = service.save(ticket);

        return ResponseEntity.status(201).body(newUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> update(@PathVariable("id") Long id, @RequestBody Ticket ticket) throws Exception {

        Ticket updatedTicket = service.update(id, ticket);

        return ResponseEntity.status(200).body(updatedTicket);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Message> remove(@PathVariable("id") Long id) throws Exception { 

        Message delete = service.delete(id);

        return ResponseEntity.status(200).body(delete);
    }

}