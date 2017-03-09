package ua.goit.java.jdbc.models.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.jdbc.models.Developer;
import ua.goit.java.jdbc.models.dao.interfaces.DAO;

import java.util.List;

public class DeveloperDao implements DAO<Developer> {
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List findAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("FROM Developer")
                .list();
    }

    @Override
    @Transactional
    public Developer getById(int id) {
        return sessionFactory
                .getCurrentSession()
                .load(Developer.class, id);
    }

    @Override
    @Transactional
    public void save(Developer entity) {
        sessionFactory
                .getCurrentSession()
                .save(entity);
    }


    @Override
    public Developer update(Developer entity) {
        sessionFactory
                .getCurrentSession()
                .update(entity);
        return entity;
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Developer developer = session.load(Developer.class, id);
        session.delete(developer);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
