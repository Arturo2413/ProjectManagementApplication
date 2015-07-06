package demo.service;

import demo.model.Developer;
import demo.model.Project;
import demo.model.Review;
import demo.model.Specialty;
import demo.repository.DeveloperRepository;
import demo.repository.ProjectRepository;
import demo.repository.ReviewRepository;
import demo.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by poo2 on 06/07/2015.
 */

@Service
public class ReviewService {

    @Autowired
    SpecialtyRepository specialtyRepository;
    @Autowired
    DeveloperRepository developerRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    ReviewRepository reviewRepository;



    public void testReview(){

        Review review1 = new Review();

        review1.setScore(8.7);

        Developer developer = developerRepository.findOne(5L);
        Specialty specialty = specialtyRepository.findOne(1L);
        Project project = projectRepository.findOne(1L);

    }
}
