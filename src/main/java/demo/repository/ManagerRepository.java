package demo.repository;

/**
 * Created by poo2 on 17/06/2015.
 */

import demo.model.Employee;
import demo.model.Manager;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


public interface ManagerRepository extends PagingAndSortingRepository<Manager,Long> {

    public List<Manager> findBySurname(@Param("surname")String surname);
    public List<Manager> findByDateIncorporationBetween(@Param("start") Date start,@Param("end") Date end );
}
