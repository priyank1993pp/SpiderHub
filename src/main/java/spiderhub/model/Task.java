package spiderhub.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//This class is for task. It contains all the information of the task.

@Entity
@Table(name = "Tasks")
public class Task implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	private String taskName;

	private String taskDescription;

	private Date createDate;

	private Date startDate;

	private Date endDate;

	@ManyToOne
	TaskPriority taskPriority;

	@ManyToOne
	Project projectTasks;

	@OneToMany(mappedBy = "taskFiles")
	Set<File> files;

	@OneToMany(mappedBy = "taskComments")
	Set<Comment> comments;

	@ManyToOne
	User userTasks;

	@ManyToOne
	TaskStatus statusTasks;

	@OneToMany(mappedBy = "activityOfTask")
	Set<TaskActivity> activities;

	private boolean isDelete;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public TaskPriority getTaskPriority() {
		return taskPriority;
	}

	public void setTaskPriority(TaskPriority taskPriority) {
		this.taskPriority = taskPriority;
	}

	public Project getProjectTasks() {
		return projectTasks;
	}

	public void setProjectTasks(Project projectTasks) {
		this.projectTasks = projectTasks;
	}

	public Set<File> getFiles() {
		return files;
	}

	public void setFiles(Set<File> files) {
		this.files = files;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public User getUserTasks() {
		return userTasks;
	}

	public void setUserTasks(User userTasks) {
		this.userTasks = userTasks;
	}

	public TaskStatus getStatusTasks() {
		return statusTasks;
	}

	public void setStatusTasks(TaskStatus statusTasks) {
		this.statusTasks = statusTasks;
	}

	public Set<TaskActivity> getActivities() {
		return activities;
	}

	public void setActivities(Set<TaskActivity> activities) {
		this.activities = activities;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
