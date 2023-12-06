package github.gmteru.project_management_api.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import github.gmteru.project_management_api.persistence.model.ProjectJPA;
import github.gmteru.project_management_api.persistence.repository.jpa.IProjectJPARepository;
import github.gmteru.project_management_api.rest.dto.ProjectDTO;
import github.gmteru.project_management_api.rest.mapper.ProjectMapper;

@Service
public class ProjectsService {
    
    @Autowired
    IProjectJPARepository repository;

    public Long count(){
        return repository.count();
    }

    public List<ProjectDTO> findAll() {
        List<ProjectJPA> projects = repository.findAll();
        return ProjectMapper.map(projects);
    }

    public ProjectDTO findById(Long id) {
        Optional<ProjectJPA> projectOptional = repository.findById(id);
        if (projectOptional.isEmpty())
            return null;

        return ProjectMapper.map(projectOptional);
    }

    public ProjectDTO create(ProjectDTO projectDTO) {
        ProjectJPA project = ProjectMapper.map(projectDTO);
        project = repository.save(project);

        return ProjectMapper.map(project);
    } 

    public void update(ProjectDTO projectDTO) {
        ProjectJPA project = ProjectMapper.map(projectDTO);
        repository.save(project);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }    
}
