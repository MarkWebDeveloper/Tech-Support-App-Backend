package dev.mark.tech_support_app_backend.services;

import java.util.List;

import dev.mark.tech_support_app_backend.messages.Message;

public interface IGenericService<T> {
    public List<T> getAll();
    public T getById(Long id) throws Exception;
    public T save(T obj);
    public T update(Long id, T obj) throws Exception;
    public Message delete (Long id) throws Exception;
}
