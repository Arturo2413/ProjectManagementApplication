package demo.repository;

import demo.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by poo2 on 16/06/2015.
 */
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {

    public List<Employee> findBySurname(@Param("surname")String surname);
     public List<Employee> findByDateIncorporationBetween(@Param("start") Date start,@Param("end") Date end );

}
