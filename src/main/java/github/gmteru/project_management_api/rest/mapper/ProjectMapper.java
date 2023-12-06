package github.gmteru.project_management_api.rest.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import github.gmteru.project_management_api.persistence.model.ProjectJPA;
import github.gmteru.project_management_api.rest.dto.ProjectDTO;

public class ProjectMapper {
    
    public static ProjectDTO map(ProjectJPA project) {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setId(project.getId());
        projectDTO.setName(project.getName());
        projectDTO.setDescription(project.getDescription());
        projectDTO.setStartDate(project.getStartDate());
        projectDTO.setEndDate(project.getEndDate());
        projectDTO.setStatus(project.getStatus());

        return projectDTO;
    }

    public static ProjectDTO map(Optional<ProjectJPA> projectOptional) {
        if (projectOptional.isEmpty())
            return null;

        return ProjectMapper.map(projectOptional.get());
    }
    
    public static List<ProjectDTO> map(List<ProjectJPA> projects) {
        List<ProjectDTO> projectsDTO = new ArrayList<>();

        if (projects == null)
            return projectsDTO;
    
        for (ProjectJPA project:projects)
            projectsDTO.add(ProjectMapper.map(project));

        return projectsDTO;
    }

    public static ProjectJPA map(ProjectDTO projectDTO) {
        ProjectJPA project = new ProjectJPA();
        project.setId(projectDTO.getId());
        project.setName(projectDTO.getName());
        project.setDescription(projectDTO.getDescription());
        project.setStartDate(projectDTO.getStartDate());
        project.setEndDate(projectDTO.getEndDate());
        project.setStatus(projectDTO.getStatus());

        return project;
    }
}