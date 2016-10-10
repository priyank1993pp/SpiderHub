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

	private String project_name;

	@ManyToOne
	Project_type project_type;

	private String project_description;

	private String project_gitHubLink;

	private Date created_date;

	private boolean isDelete;

	@ManyToMany
	Set<User> users_related_project;

	@ManyToOne
	User created_user;

	@OneToMany(mappedBy = "project_tasks")
	Set<Task> tasks;

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public String getProject_gitHubLink() {
		return project_gitHubLink;
	}

	public void setProject_gitHubLink(String project_gitHubLink) {
		this.project_gitHubLink = project_gitHubLink;
	}

	public Set<User> getUsers_related_project() {
		return users_related_project;
	}

	public void setUsers_related_project(Set<User> users_related_project) {
		this.users_related_project = users_related_project;
	}

	public User getCreated_user() {
		return created_user;
	}

	public void setCreated_user(User created_user) {
		this.created_user = created_user;
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
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public Project_type getProject_type() {
		return project_type;
	}

	public void setProject_type(Project_type project_type) {
		this.project_type = project_type;
	}

	public String getProject_description() {
		return project_description;
	}

	public void setProject_description(String project_description) {
		this.project_description = project_description;
	}

}
