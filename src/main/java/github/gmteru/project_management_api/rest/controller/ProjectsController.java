package github.gmteru.project_management_api.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import github.gmteru.project_management_api.rest.dto.ProjectDTO;
import github.gmteru.project_management_api.rest.service.ProjectsService;

@RestController
@RequestMapping("/projects")
public class ProjectsController {
    @Autowired
    ProjectsService service;

    @GetMapping("/count")
    public Long count() {
        return service.count();
    }

    @GetMapping("")
    public List<ProjectDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ProjectDTO findById(@PathVariable Long id) {
        ProjectDTO project = service.findById(id);
        if(project == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
            "Entity not found.");
        }

        return project;
    }

    @PostMapping("")
    @ResponseStatus(code=HttpStatus.CREATED)
    public ProjectDTO create(@RequestBody ProjectDTO project) {
        return service.create(project);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT, reason="Entity updated")
    public void update(@PathVariable int id, @RequestBody ProjectDTO project) {
        if (id != project.getId()) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED,
            "Error in query");       
        }

        service.update(project);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT, reason="Entity deleted")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
