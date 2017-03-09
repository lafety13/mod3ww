package ua.goit.java.jdbc.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.jdbc.models.Project;
import ua.goit.java.jdbc.models.dao.ProjectDao;
import ua.goit.java.jdbc.views.Output;

import java.util.List;


public class ProjectController {
    private ProjectDao projectDAO;

    @Transactional
    public void getAllProjects() {
        List<?> result = projectDAO.findAll();
        Output.printEntity(result);
    }

    @Transactional
    public void getProjectById(int id) {
        Project result = projectDAO.getById(id);
        Output.printEntity(result);
    }

    @Transactional
    public void update() {

    }

    @Transactional
    public void create(Project entity) {
        projectDAO.save(entity);
        Output.printEntity("Developer was successfully created");
    }

    @Transactional
    public void delete(int id) {
        projectDAO.delete(id);
        Output.printEntity("Developer was successfully deleted");
    }

    @Transactional
    public void addDeveloperTo(int developerId, int projectId) {
        projectDAO.addDeveloperTo(developerId, projectId);
        Output.printEntity("Developer was successfully added");
    }

    @Transactional
    public void deleteDeveloperFrom(int developerId) {
        projectDAO.deleteDeveloperFrom(developerId);
        Output.printEntity("Developer was successfully deleted from project");
    }

    public void setProjectDAO(ProjectDao projectDAO) {
        this.projectDAO = projectDAO;
    }
}
