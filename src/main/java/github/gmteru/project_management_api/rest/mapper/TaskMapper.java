package github.gmteru.project_management_api.rest.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import github.gmteru.project_management_api.persistence.model.TaskJPA;
import github.gmteru.project_management_api.rest.dto.TaskDTO;

public class TaskMapper {

    public static TaskDTO map(TaskJPA task) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setIdProject(task.getIdProject());
        taskDTO.setDueDate(task.getDueDate());
        taskDTO.setStatus(task.getStatus());

        return taskDTO;
    }

    public static TaskDTO map(Optional<TaskJPA> taskOptional) {
        if (taskOptional.isEmpty())
            return null;
        
        return TaskMapper.map(taskOptional.get());
    }

    public static List<TaskDTO> map(List<TaskJPA> tasks) {
        List<TaskDTO> tasksDTO = new ArrayList<>();

        if (tasks == null)
            return tasksDTO;
        
        for (TaskJPA task:tasks)
            tasksDTO.add(TaskMapper.map(task));

        return tasksDTO;
    }

    public static TaskJPA map(TaskDTO taskDTO) {
        TaskJPA task = new TaskJPA();
        task.setId(taskDTO.getId());
        task.setIdProject(taskDTO.getIdProject());
        task.setDueDate(taskDTO.getDueDate());
        task.setStatus(taskDTO.getStatus());

        return task;
    }
}