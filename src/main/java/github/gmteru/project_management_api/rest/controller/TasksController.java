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

import github.gmteru.project_management_api.rest.dto.TaskDTO;
import github.gmteru.project_management_api.rest.service.TasksService;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    
    @Autowired
    TasksService service;

    @GetMapping("/count")
    public Long count() {
        return service.count();
    }

    @GetMapping("")
    public List<TaskDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public TaskDTO findById(@PathVariable Long id) {
        TaskDTO task = service.findById(id);
        if (task == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
            "Entity not found");
        }

        return task;
    }

    @PostMapping("")
    @ResponseStatus(code=HttpStatus.CREATED)
    public TaskDTO create(@RequestBody TaskDTO task) {
        return service.create(task);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT, reason = "Entity updated")
    public void update(@PathVariable int id, @RequestBody TaskDTO task) {
        if (id != task.getId()) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED,
            "Error in query");
        }
    
        service.update(task);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT, reason = "Entity deleted")
    public void delete (@PathVariable Long id) {
        service.delete(id);
    }
}
