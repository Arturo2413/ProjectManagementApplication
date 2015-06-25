package demo.service;

import demo.model.*;
import demo.repository.DeveloperRepository;
import demo.repository.ManagerRepository;
import demo.repository.ProjectRepository;
import demo.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by poo2 on 17/06/2015.
 */

@Service
public class ProjectService {

    @Autowired
    ManagerRepository managerRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    DeveloperRepository developerRepository;
    @Autowired
    SpecialtyRepository specialtyRepository;

    public void testProject(){

    //Añadimos un projecto con sus atributos
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JANUARY, 1);
        Date startDate = calendar.getTime();

        Project project = new Project();
        project.setDescription("Proyecto de JAVA");
        project.setStartDate(startDate);

        calendar.set(2015, Calendar.SEPTEMBER, 1);
        Date endDate = calendar.getTime();
        project.setEndDate(endDate);

        Manager manager =  managerRepository.findBySurname("Boss").get(0);
        project.setManager(manager);

        //Aqui buscamos un developer en concreto y lo vinculamos para la tabla project_developers_specialties
        Developer d = developerRepository.findByCategory(Category.JUNIOR).get(0);
        project.getDevelopers().add(d);




        projectRepository.save(project);



    }
}
