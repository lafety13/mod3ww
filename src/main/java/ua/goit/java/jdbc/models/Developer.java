package ua.goit.java.jdbc.models;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "hibernate_dev")
public class Developer {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @Column(name = "developer_name")
    private String name;

    @Column(name = "salary")
    private Float salary;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "project_id")
    @IndexColumn(name = "id")
    private Project project;

    public Developer() {
    }

    public Developer(String name, Float salary) {
        this.name = name;
        this.salary = salary;
    }

    public Developer(String name, Float salary, Project project) {
        this.name = name;
        this.salary = salary;
        this.project = project;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Developer developer = (Developer) o;

        if (id != developer.id) return false;
        if (name != null ? !name.equals(developer.name) : developer.name != null) return false;
        if (salary != null ? !salary.equals(developer.salary) : developer.salary != null) return false;
        return project != null ? project.equals(developer.project) : developer.project == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (project != null ? project.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", project=" + (!Objects.isNull(project) ? project.getName() : "[]") +
                '}';
    }
}
