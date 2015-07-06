package demo.controller;

import demo.Exception.*;
import demo.model.*;
import demo.repository.DeveloperRepository;
import demo.repository.ProjectRepository;
import demo.repository.ReviewRepository;
import demo.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by poo2 on 06/07/2015.
 */

@RestController
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private DeveloperRepository developerRepository;
    @Autowired
    private SpecialtyRepository specialtyRepository;


    @RequestMapping(value="/projects/{idProject}/developers/{idDeveloper}/specialities/{idSpeciality}/review", method= RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Review addReview(@PathVariable Long idProject,@PathVariable Long idDeveloper,@PathVariable Long idSpecialty,
                            @RequestBody Review review ) {

// Instanciamos un projecto a partir del id recibido
        Project project = projectRepository.findOne(idProject);

// Si no existe lanzamos excepcion
        if (project == null)
            throw new ProjectException(idProject);

// Instanciamos un developer a partir del id recibido
        Developer developer = developerRepository.findOne(idDeveloper);

// Si no existe lanzamos excepcion
        if (developer == null)
            throw new DeveloperException(idDeveloper);

        Specialty specialty = specialtyRepository.findOne(idSpecialty);

        if (specialty == null)
            throw new SpecialtyException(idSpecialty);

/*  */
        if ( ! developer.getProjects().contains(project) )
            throw new ReviewDeveloperProjectException(idProject, idDeveloper);


        if ( ! project.getSpecialties().contains(specialty) )
            throw  new ReviewProjectSpecialtyException(idProject, idSpecialty);

        if ( ! developer.getSpecialties().contains(specialty) )
            throw new ReviewDeveloperSpecialtyException(idDeveloper, idSpecialty);

        review.setDate(new Date());
        review.setProject(project);
        review.setDeveloper(developer);
        review.setSpecialty(specialty);

        reviewRepository.save(review);

        return review;
    }


    @RequestMapping(method = GET)
    public List<Review> findAll(){
        List<Review> reviews = new ArrayList<Review>();
        Iterator<Review> iterator = reviewRepository.findAll().iterator();

        while (iterator.hasNext())
        {
            reviews.add(iterator.next());
        }

        return reviews;
    }

    @RequestMapping(value = "/{id}", method = GET)
    public Review getById(@PathVariable Long id){
        Review review = reviewRepository.findOne(id);

        if(review == null)
            throw new ReviewException(id);

        return review;

    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public void delById(@PathVariable Long id){
        Review review = reviewRepository.findOne(id);

        if(review == null)
            throw new ReviewException(id);

        reviewRepository.delete(id);

    }
    //Guardar un Review
    @RequestMapping(value = "/{id}", method = PUT)
    public Review updateById(@PathVariable Long id, @RequestBody Review newReview){
        Review review = reviewRepository.findOne(id);

        if(review == null)
            throw new ReviewException(id);

        newReview = reviewRepository.save(newReview);

        return newReview;

    }



}
