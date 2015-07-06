package demo.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by poo2 on 06/07/2015.
 */

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private double score;

    @ManyToOne
    private Developer developer;

   /* @ManyToOne
    @Column(name = "id_manager")
    private Manager manager;
    */

    @ManyToOne
    private Specialty specialty;

    @ManyToOne
    private Project project;

    @Column
    private Date date;

    public Review() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
