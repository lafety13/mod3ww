package ua.goit.java.jdbc.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.jdbc.models.Developer;
import ua.goit.java.jdbc.models.dao.DeveloperDao;
import ua.goit.java.jdbc.views.Output;

import java.util.List;

public class DeveloperController {
    private DeveloperDao developerDao;

    @Transactional
    public void getAllDevelopers() {
        List<?> developers = developerDao.findAll();
        Output.printEntity(developers);
    }

    @Transactional
    public void create(Developer entity) {
        developerDao.save(entity);
    }


    @Transactional
    public void getDeveloperById(int id) {
        Developer developer = developerDao.getById(id);
        Output.printEntity(developer);
    }

    @Transactional
    public void update(String name, float salary) {
       Developer developer = new Developer(name, salary);
        Developer updatedDeveloper = developerDao.update(developer);
        Output.printEntity(updatedDeveloper);
    }

    @Transactional
    public void delete(int id) {
        developerDao.delete(id);
    }


    public void setDeveloperDao(DeveloperDao developerDao) {
        this.developerDao = developerDao;
    }
}
