package demo.service;

import demo.model.Category;
import demo.model.Developer;
import demo.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by poo2 on 17/06/2015.
 */

@Service
public class DeveloperService {

    /**
     * Test Developers
     */
    @Autowired
    DeveloperRepository developerRepository;

    public void testDevelopers(){

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
    }
}
