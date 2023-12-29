package dev.mark.tech_support_app_backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.mark.tech_support_app_backend.exceptions.UserNotFoundException;
import dev.mark.tech_support_app_backend.messages.Message;
import dev.mark.tech_support_app_backend.models.User;
import dev.mark.tech_support_app_backend.repositories.UserRepository;

@Service
public class UserService implements IGenericService<User> {
    
    UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAll() {
        List<User> users = repository.findAll();
        return users;
    }

    public User getById(Long id) throws Exception {
        User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));

        return user;
    }

    public User save(User user) {
        
        User newMovie = repository.save(user);
        return newMovie;
    }

    public User update(Long id, User user) throws Exception {
        
        User updatingUser = repository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        
        updatingUser.setName(user.getName());
        updatingUser.setUsername(user.getUsername());
        updatingUser.setPassword(user.getPassword());
        updatingUser.setType(user.getType());

        User updatedMovie = repository.save(updatingUser);
        
        return updatedMovie;
    }

    public Message delete(Long id) throws Exception {
        
        User user = repository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));

        String userName = user.getUsername();

        repository.delete(user);

        Message message = new Message();

        message.setMessage(userName + " is deleted from the movies table");

        return message;
    }
}
