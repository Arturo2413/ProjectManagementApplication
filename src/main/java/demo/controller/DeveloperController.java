package demo.controller;

import demo.Exception.DeveloperException;
import demo.model.Developer;
import demo.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by poo2 on 29/06/2015.
 */
@RestController
@RequestMapping("/developer")
public class DeveloperController {

    @Autowired
    private DeveloperRepository developerRepository;

    @RequestMapping(method = POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Developer save(@RequestBody Developer developer){
        return developerRepository.save(developer);
    }

    @RequestMapping(method = GET)
    public List<Developer> findAll(){
        List<Developer> developers = new ArrayList<Developer>();
        Iterator<Developer> iterator = developerRepository.findAll().iterator();

        while (iterator.hasNext())
        {
            developers.add(iterator.next());
        }

        return developers;
    }


    @RequestMapping(value = "/{id}", method = GET)
    public Developer getById(@PathVariable Long id){
        Developer developer = developerRepository.findOne(id);

        if(developer == null)
            throw new DeveloperException(id);

        return developer;

    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public void delById(@PathVariable Long id){
        Developer developer = developerRepository.findOne(id);

        if(developer == null)
            throw new DeveloperException(id);

        developerRepository.delete(id);

    }
}
