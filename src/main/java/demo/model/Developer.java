package demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by poo2 on 17/06/2015.
 */

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Developer extends Employee {


    @Column
    @Enumerated(EnumType.STRING)
    private Category category;

    @JsonIgnore
    @ManyToMany(mappedBy = "developers")
    private Set<Project> projects = new HashSet<>();

    @JsonIgnore
    @ManyToMany
    private Set<Specialty> specialties = new HashSet<>();

    public Developer() {
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {

        String developer = super.toString();
        return developer + "Developer{" +
                "category=" + category +
                '}';
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }
}



