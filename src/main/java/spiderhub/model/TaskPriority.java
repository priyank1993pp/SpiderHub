package spiderhub.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//This class is for prioritizing any task.

@Entity
@Table(name = "priorityOfTask")
public class TaskPriority implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	private String priorityType;

	private int priorityNum;

	private Date createDate;

	@OneToMany(mappedBy = "taskPriority")
	Set<Task> tasks;

	public Date getCreate_date() {
		return createDate;
	}

	public void setCreate_date(Date create_date) {
		this.createDate = create_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPriority_type() {
		return priorityType;
	}

	public void setPriority_type(String priority_type) {
		this.priorityType = priority_type;
	}

	public int getPriority_num() {
		return priorityNum;
	}

	public void setPriority_num(int priority_num) {
		this.priorityNum = priority_num;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
}
