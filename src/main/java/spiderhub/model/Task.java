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

	private String task_name;

	private String task_description;

	private Date create_date;

	private Date start_date;

	private Date end_date;

	@ManyToOne
	Task_priority taskPriority;

	private int group_id;

	@ManyToOne
	Project project_tasks;

	@OneToMany(mappedBy = "task_files")
	Set<File> files;

	@OneToMany(mappedBy = "task_comments")
	Set<Comment> comments;

	@ManyToOne
	User userTasks;

	@ManyToOne
	Task_status statusTasks;

	@OneToMany(mappedBy = "activityOfTask")
	Set<Task_activity> activities;

	private boolean isDelete;

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Task_status getStatusTasks() {
		return statusTasks;
	}

	public void setStatusTasks(Task_status statusTasks) {
		this.statusTasks = statusTasks;
	}

	public Set<Task_activity> getActivities() {
		return activities;
	}

	public void setActivities(Set<Task_activity> activities) {
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

	public Task_priority getTaskPriority() {
		return taskPriority;
	}

	public void setTaskPriority(Task_priority taskPriority) {
		this.taskPriority = taskPriority;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public String getTask_description() {
		return task_description;
	}

	public void setTask_description(String task_description) {
		this.task_description = task_description;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public Project getProject_tasks() {
		return project_tasks;
	}

	public void setProject_tasks(Project project_tasks) {
		this.project_tasks = project_tasks;
	}
}
