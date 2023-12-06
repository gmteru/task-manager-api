package github.gmteru.project_management_api.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import github.gmteru.project_management_api.persistence.model.TaskJPA;
import github.gmteru.project_management_api.persistence.repository.jpa.ITaskJPARepository;
import github.gmteru.project_management_api.rest.dto.TaskDTO;
import github.gmteru.project_management_api.rest.mapper.TaskMapper;

@Service
public class TasksService {
    
    @Autowired
    ITaskJPARepository repository;

    public Long count(){
        return repository.count();
    }

    public List<TaskDTO> findAll() {
        List<TaskJPA> tasks = repository.findAll();
        return TaskMapper.map(tasks);
    }

    public TaskDTO findById(Long id) {
        Optional<TaskJPA> taskOptional = repository.findById(id);
        if (taskOptional.isEmpty())
            return null;

        return TaskMapper.map(taskOptional);
    }

    public TaskDTO create(TaskDTO taskDTO) {
        TaskJPA task = TaskMapper.map(taskDTO);
        task = repository.save(task);

        return TaskMapper.map(task);
    } 

    public void update(TaskDTO taskDTO) {
        TaskJPA task = TaskMapper.map(taskDTO);
        repository.save(task);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }    

}
