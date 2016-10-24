package spiderhub.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

//This class is for project details like who created this project, whom working on this project. 

@Entity
@Table(name = "Projects")
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	private String projectName;

	@ManyToOne
	ProjectType projectType;

	private String projectDescription;

	private String projectGitHubLink;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date createdDate;

	private boolean isDelete;

	@ManyToMany
	Set<User> usersRelatedProject;

	@ManyToOne
	User createdUser;

	@OneToMany(mappedBy = "projectTasks")
	Set<Task> tasks;

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getProjectGitHubLink() {
		return projectGitHubLink;
	}

	public void setProjectGitHubLink(String projectGitHubLink) {
		this.projectGitHubLink = projectGitHubLink;
	}

	public Set<User> getUsersRelatedProject() {
		return usersRelatedProject;
	}

	public void setUsersRelatedProject(Set<User> usersRelatedProject) {
		this.usersRelatedProject = usersRelatedProject;
	}

	public User getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(User createdUser) {
		this.createdUser = createdUser;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public ProjectType getProjectType() {
		return projectType;
	}

	public void setProjectType(ProjectType projectType) {
		this.projectType = projectType;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

}
