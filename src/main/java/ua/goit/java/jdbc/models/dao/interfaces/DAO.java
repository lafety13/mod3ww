package ua.goit.java.jdbc.models.dao.interfaces;

import java.util.List;

public interface DAO<T> {
    List findAll();
    T getById(int id);
    void save(T entity);
    T update(T entity);
    void delete(int id);
}
