package github.gmteru.project_management_api.persistence.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import github.gmteru.project_management_api.persistence.model.ProjectJPA; 

public interface IProjectJPARepository extends JpaRepository<ProjectJPA, Long>{
    
}
