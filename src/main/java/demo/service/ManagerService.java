package demo.service;

import demo.model.Manager;
import demo.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by poo2 on 17/06/2015.
 */

@Service
public class ManagerService {

    @Autowired
    ManagerRepository managerRepository;

    public void testManagers(){

        Manager manager1 = new Manager();
        manager1.setName("The");
        manager1.setSurname("Boss");
        manager1.setSalary(12000000.0);
        manager1.setBonusSuccess(123.0);
        manager1.setDateIncorporation(new Date());

        managerRepository.save(manager1);
    }
}
