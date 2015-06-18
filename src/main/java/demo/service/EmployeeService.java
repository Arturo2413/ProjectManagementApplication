package demo.service;

import demo.model.Category;
import demo.model.Developer;
import demo.model.Employee;
import demo.model.Project;
import demo.repository.DeveloperRepository;
import demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by poo2 on 16/06/2015.
 */

@Service
public class EmployeeService {

    /**
     * Test Employees
     */
    @Autowired
    private EmployeeRepository employeeRepository;

    public void testEmployees(){

        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JANUARY, 1);
        Date startDate = calendar.getTime();

        calendar.set(2015, Calendar.MARCH, 1);
        Date endDate = calendar.getTime();

        calendar.set(2015, Calendar.FEBRUARY, 1);
        Date creationDate = calendar.getTime();

        Employee employee = new Employee();
        employee.setName("Arturo");
        employee.setSurname("Garcia Gonzalvez");
        employee.setSalary(2400.0);
        employee.setDateIncorporation(new Date());

        employeeRepository.save(employee);

        Employee employee1 = new Employee();
        employee1.setName("Ricardo");
        employee1.setSurname("Garcia Gonzalvez");
        employee1.setSalary(2100.0);
        employee1.setDateIncorporation(new Date());

        employeeRepository.save(employee1);

        Employee employee2 = new Employee();
        employee2.setName("Eric");
        employee2.setSurname("Lavado Diaz");
        employee2.setSalary(2200.0);
        employee2.setDateIncorporation(new Date());

        employeeRepository.save(employee2);

        Employee employee3 = new Employee();
        employee3.setName("Xavi");
        employee3.setSurname("Rodriguez Trabal");
        employee3.setSalary(1400.0);
        employee3.setDateIncorporation(creationDate);

        employeeRepository.save(employee3);

        List<Employee> garcia = employeeRepository.findBySurname("Garcia Gonzalvez");

        System.out.println("############## Filtro Employees #############");

        for(Employee emp : garcia){
            System.out.println(emp);
        }

        List<Employee> employees = employeeRepository.findByDateIncorporationBetween(startDate, endDate);

        for(Employee emp1 : employees){
            System.out.println(emp1);
        }

        Project p = new Project();
        Developer d = new Developer();

        p.getDevelopers().add(d);
        d.getProjects().add(p);
    }

}

