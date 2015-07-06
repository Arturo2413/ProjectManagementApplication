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

import javax.transaction.Transactional;

/**
 * Created by poo2 on 25/06/2015.
 */

@Service
@Transactional
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

        Developer d = developerRepository.findByCategory(Category.JUNIOR).get(0);
        Project p = projectRepository.findOne(1L);

        Specialty specialty1 = new Specialty();
        specialty1.setName("HTML5");

        specialtyRepository.save(specialty1);

        p.getSpecialties().add(specialty1);

        d.getProjects().add(p);

        developerRepository.save(d);



        //guardamos la specialty

        Specialty specialty2 = new Specialty();
        specialty2.setName("JAVA");
        specialtyRepository.save(specialty2);

        Specialty specialty3 = new Specialty();
        specialty3.setName("MongoDB");
        specialtyRepository.save(specialty3);









    }
}
