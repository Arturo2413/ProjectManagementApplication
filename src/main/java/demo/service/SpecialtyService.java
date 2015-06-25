package demo.service;

import demo.model.Category;
import demo.model.Developer;
import demo.model.Project;
import demo.model.Specialty;
import demo.repository.DeveloperRepository;
import demo.repository.ProjectRepository;
import demo.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by poo2 on 25/06/2015.
 */

@Service
public class SpecialtyService {

    /**
     * Test specialty
     */

    @Autowired
    SpecialtyRepository specialtyRepository;
    @Autowired
    DeveloperRepository developerRepository;
    @Autowired
    ProjectRepository projectRepository;

    public void testSpecialty(){

//Una especialidad en un developer y en un proyecto
        Specialty specialty1 = new Specialty();
        specialty1.setName("HTML5");

        Developer d = developerRepository.findByCategory(Category.JUNIOR).get(1);
        specialty1.getDevelopers().add(d);


        Project p = projectRepository.findOne(1L);
        specialty1.getProjects().add(p);

        specialtyRepository.save(specialty1);

        //guardamos la specialty

        Specialty specialty2 = new Specialty();
        specialty2.setName("JAVA");
        specialtyRepository.save(specialty2);

        Specialty specialty3 = new Specialty();
        specialty3.setName("MongoDB");
        specialtyRepository.save(specialty3);









    }
}
