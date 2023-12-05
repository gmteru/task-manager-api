package github.gmteru.project_management_api.persistence.model;

import java.sql.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="tasks")
@JsonInclude(Include.NON_NULL)
public class TaskJPA {
    private Long id;
    private Long idProject;
    private Date dueDate;
    private String status;

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
            
        TaskJPA other = (TaskJPA) object;

        return Objects.equals(id, other.id);
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getIdProject() {
        return idProject;
    }
    public void setIdProject(Long idProject) {
        this.idProject = idProject;
    }
    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    
}
