package demo.service;

import demo.model.Category;
import demo.model.Developer;
import demo.model.Project;
import demo.repository.DeveloperRepository;
import demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by poo2 on 17/06/2015.
 */

@Service
@Transactional
public class DeveloperService {

    /**
     * Test Developers
     */
    @Autowired
    DeveloperRepository developerRepository;
    @Autowired
    ProjectRepository projectRepository;

    public void testDevelopers(){


        //Damos de alta a varios developers
        Developer developer1 = new Developer();
        developer1.setName("Arturo");
        developer1.setSurname("Garcia");
        developer1.setSalary(3400.0);
        developer1.setCategory(Category.JUNIOR);
        developer1.setDateIncorporation(new Date());

        developerRepository.save(developer1);

        Developer developer2 = new Developer();
        developer2.setName("Ricardo");
        developer2.setSurname("Gonzalvez");
        developer2.setSalary(3200.0);
        developer2.setCategory(Category.SENIOR);
        developer2.setDateIncorporation(new Date());

        developerRepository.save(developer2);

        Developer developer3 = new Developer();
        developer3.setName("Xavi");
        developer3.setSurname("Rodriguez");
        developer3.setSalary(1200.0);
        developer3.setCategory(Category.ARCHITECT);
        developer3.setDateIncorporation(new Date());

        developerRepository.save(developer3);

        Developer developer4 = new Developer();
        developer4.setName("Junior");
        developer4.setSurname("El Kabouri");
        developer4.setSalary(200.0);
        developer4.setCategory(Category.JUNIOR);
        developer4.setDateIncorporation(new Date());

        developerRepository.save(developer4);


//Hacemos una busqueda por categoria, guardando el resultado en una lista
        List<Developer> junior = developerRepository.findByCategory(Category.JUNIOR);

        System.out.println("############## Filtro Developers #############");
        for(Developer dev : junior){

            System.out.println(dev);
        }

    }
}
