package demo.service;

import demo.model.Manager;
import demo.model.Project;
import demo.repository.ManagerRepository;
import demo.repository.ProjectRepository;
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

    public void testProject(){


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


        projectRepository.save(project);
    }
}
