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

	public Date getCreate_date() {
		return createDate;
	}

	public void setCreate_date(Date create_date) {
		this.createDate = create_date;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
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

	public User getUserTasks() {
		return userTasks;
	}

	public void setUserTasks(User userTasks) {
		this.userTasks = userTasks;
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

	public TaskPriority getTaskPriority() {
		return taskPriority;
	}

	public void setTaskPriority(TaskPriority taskPriority) {
		this.taskPriority = taskPriority;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTask_name() {
		return taskName;
	}

	public void setTask_name(String task_name) {
		this.taskName = task_name;
	}

	public String getTask_description() {
		return taskDescription;
	}

	public void setTask_description(String task_description) {
		this.taskDescription = task_description;
	}

	public Date getStart_date() {
		return startDate;
	}

	public void setStart_date(Date start_date) {
		this.startDate = start_date;
	}

	public Date getEnd_date() {
		return endDate;
	}

	public void setEnd_date(Date end_date) {
		this.endDate = end_date;
	}

	public Project getProject_tasks() {
		return projectTasks;
	}

	public void setProject_tasks(Project project_tasks) {
		this.projectTasks = project_tasks;
	}
}
