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

import github.gmteru.project_management_api.persistence.model.TaskJPA;
import github.gmteru.project_management_api.persistence.repository.jpa.ITaskJPARepository;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    @Autowired
    ITaskJPARepository repository;

    @GetMapping("/count")
    public Long count() {
        return repository.count();
    }

    @GetMapping("")
    public List<TaskJPA> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public TaskJPA findById(@PathVariable Long id) {
        Optional<TaskJPA> task = repository.findById(id);
        if (task.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
            "Entity not found");
        }

        return task.get();
    }

    @PostMapping("")
    @ResponseStatus(code=HttpStatus.CREATED)
    public TaskJPA create(@RequestBody TaskJPA task) {
        return repository.save(task);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT, reason = "Entity updated")
    public void update(@PathVariable int id, @RequestBody TaskJPA task) {
        if (id != task.getId()) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED,
            "Error in query");
        }
    
        repository.save(task);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT, reason = "Entity deleted")
    public void delete (@PathVariable Long id) {
        repository.deleteById(id);
    }
}
