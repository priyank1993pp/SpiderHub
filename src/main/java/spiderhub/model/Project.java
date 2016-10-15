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

	public Date getCreated_date() {
		return createdDate;
	}

	public void setCreated_date(Date created_date) {
		this.createdDate = created_date;
	}

	public String getProject_gitHubLink() {
		return projectGitHubLink;
	}

	public void setProject_gitHubLink(String project_gitHubLink) {
		this.projectGitHubLink = project_gitHubLink;
	}

	public Set<User> getUsers_related_project() {
		return usersRelatedProject;
	}

	public void setUsers_related_project(Set<User> users_related_project) {
		this.usersRelatedProject = users_related_project;
	}

	public User getCreated_user() {
		return createdUser;
	}

	public void setCreated_user(User created_user) {
		this.createdUser = created_user;
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

	public String getProject_name() {
		return projectName;
	}

	public void setProject_name(String project_name) {
		this.projectName = project_name;
	}

	public ProjectType getProject_type() {
		return projectType;
	}

	public void setProject_type(ProjectType project_type) {
		this.projectType = project_type;
	}

	public String getProject_description() {
		return projectDescription;
	}

	public void setProject_description(String project_description) {
		this.projectDescription = project_description;
	}

}
