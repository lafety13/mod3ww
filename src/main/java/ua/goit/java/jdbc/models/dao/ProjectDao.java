package ua.goit.java.jdbc.models.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.jdbc.models.Developer;
import ua.goit.java.jdbc.models.Project;
import ua.goit.java.jdbc.models.dao.interfaces.DAO;

import java.util.List;

public class ProjectDao implements DAO<Project> {
    private SessionFactory sessionFactory;

   @Override
    @Transactional
    public List findAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("FROM Project")
                .list();
    }

    @Override
    public Project getById(int id) {
        return  sessionFactory
                .getCurrentSession()
                .load(Project.class, id);
    }

    @Override
    public void save(Project entity) {
        sessionFactory
                .getCurrentSession()
                .save(entity);
    }

    @Override
    public Project update(Project entity) {
        sessionFactory
                .getCurrentSession()
                .update(entity);
        return entity;
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Project project = session.load(Project.class, id);
        session.delete(project);
    }

    public void addDeveloperTo(int developerId, int projectId) {
        Session session = sessionFactory.getCurrentSession();
        Project project = session.load(Project.class, projectId);
        Developer developer = session.load(Developer.class, developerId);

        List<Developer> developerList = project.getDeveloperList();
        developerList.add(developer);
        project.setDeveloperList(developerList);

        session.update(project);
    }

    public void deleteDeveloperFrom(int developerId) {
        Session session = sessionFactory.getCurrentSession();

        Developer developer = session.load(Developer.class, developerId);
        Project project = null;
        developer.setProject(project);
        session.update(developer);
    }
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
