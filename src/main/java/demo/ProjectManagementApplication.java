package demo;

import demo.model.Developer;
import demo.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 */

@SpringBootApplication
public class ProjectManagementApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ProjectManagementApplication.class, args);

        EmployeeService employeeService = context.getBean(EmployeeService.class);
        DeveloperService developerService = context.getBean(DeveloperService.class);
        ManagerService managerService = context.getBean(ManagerService.class);
        ProjectService projectService = context.getBean(ProjectService.class);
        SpecialtyService specialtyService = context.getBean(SpecialtyService.class);
        ReviewService reviewServices = context.getBean(ReviewService.class);

        employeeService.testEmployees();
        developerService.testDevelopers();
        managerService.testManagers();
        projectService.testProject();
        specialtyService.testSpecialty();
        reviewServices.testReview();



    }
}
