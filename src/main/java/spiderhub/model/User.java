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

//This class is for user.It contains all the informations of the user.

@Entity
@Table(name = "Users")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	private String userName;

	private String emailAddress;

	private String password;

	private String phoneNumber;

	private Date createDate;

	private boolean isDelete;

	@ManyToOne
	UserRole userRole;

	@ManyToMany(mappedBy = "usersRelatedProject")
	Set<Project> projects;

	@OneToMany(mappedBy = "createdUser")
	Set<Project> project;

	@OneToMany(mappedBy = "userComment")
	Set<Comment> comments;

	@OneToMany(mappedBy = "userTasks")
	Set<Task> tasks;

	@OneToMany(mappedBy = "activityOfTaskByUser")
	Set<TaskActivity> activities;

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public UserRole getUser_role() {
		return userRole;
	}

	public void setUser_role(UserRole user_role) {
		this.userRole = user_role;
	}

	public Date getCreate_date() {
		return createDate;
	}

	public void setCreate_date(Date create_date) {
		this.createDate = create_date;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public Set<TaskActivity> getActivities() {
		return activities;
	}

	public void setActivities(Set<TaskActivity> activities) {
		this.activities = activities;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public Set<Project> getProject() {
		return project;
	}

	public void setProject(Set<Project> project) {
		this.project = project;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return userName;
	}

	public void setName(String name) {
		this.userName = name;
	}

	public String getEmail() {
		return emailAddress;
	}

	public void setEmail(String email) {
		this.emailAddress = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone_number() {
		return phoneNumber;
	}

	public void setPhone_number(String phone_number) {
		this.phoneNumber = phone_number;
	}
}