package github.gmteru.project_management_api.rest;

import java.util.List;
import java.util.Optional;

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

import github.gmteru.project_management_api.persistence.model.ProjectJPA;
import github.gmteru.project_management_api.persistence.repository.jpa.IProjectJPARepository;

@RestController
@RequestMapping("/projects")
public class ProjectsController {
    @Autowired
    IProjectJPARepository repository;

    @GetMapping("/count")
    public Long count() {
        return repository.count();
    }

    @GetMapping("")
    public List<ProjectJPA> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ProjectJPA findById(@PathVariable Long id) {
        Optional<ProjectJPA> project = repository.findById(id);
        if(project.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
            "Entity not found.");
        }

        return project.get();
    }

    @PostMapping("")
    @ResponseStatus(code=HttpStatus.CREATED)
    public ProjectJPA create(@RequestBody ProjectJPA project) {
        return repository.save(project);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT, reason="Entity updated")
    public void update(@PathVariable int id, @RequestBody ProjectJPA project) {
        if (id != project.getId()) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED,
            "Error in query");       
        }

        repository.save(project);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT, reason="Entity deleted")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
