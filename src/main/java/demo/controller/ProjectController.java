package demo.controller;


import demo.Exception.ProjectException;
import demo.model.Manager;
import demo.model.Project;
import demo.repository.ManagerRepository;
import demo.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;
/**
 * Created by poo2 on 01/07/2015.
 */
@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ManagerRepository managerRepository;


    @RequestMapping(method = POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Project save(@RequestBody Project project){
        return projectRepository.save(project);
    }

    @RequestMapping(method = GET)
    public List<Project> findAll(){
        List<Project> projects = new ArrayList<Project>();
        Iterator<Project> iterator = projectRepository.findAll().iterator();

        while (iterator.hasNext())
        {
            projects.add(iterator.next());
        }

        return projects;
    }

    @RequestMapping(value = "/{id}", method = GET)
    public Project getById(@PathVariable Long id){
        Project project = projectRepository.findOne(id);

        if(project == null)
            throw new ProjectException(id);

        return project;

    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public void delById(@PathVariable Long id){
        Project project = projectRepository.findOne(id);

        if(project == null)
            throw new ProjectException(id);

        projectRepository.delete(id);

    }
    //Guardar un Project
    @RequestMapping(value = "/{id}", method = PUT)
    public Project updateById(@PathVariable Long id, @RequestBody Project newProject){
        Project project = projectRepository.findOne(id);

        if(project == null)
            throw new ProjectException(id);

        newProject = projectRepository.save(newProject);

        return newProject;

    }


    @RequestMapping(value="/{idProject}/manager/{idManager}", method = POST)
    public Project addManager(@PathVariable Long idProject,@PathVariable Long idManager) {

        Project project = projectRepository.findOne(idProject);

        if(project == null)
            throw new ProjectException(idProject);

        Manager manager = managerRepository.findOne(idManager);

        if(manager == null)
            throw new ProjectException(idProject);

        project.setManager(manager);

        projectRepository.save(project);

        return project;
    }
}
