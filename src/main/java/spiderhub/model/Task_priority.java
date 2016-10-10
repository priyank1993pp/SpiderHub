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
public class Task_priority implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	private String priority_type;

	private int priority_num;

	private Date create_date;

	@OneToMany(mappedBy = "taskPriority")
	Set<Task> tasks;

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPriority_type() {
		return priority_type;
	}

	public void setPriority_type(String priority_type) {
		this.priority_type = priority_type;
	}

	public int getPriority_num() {
		return priority_num;
	}

	public void setPriority_num(int priority_num) {
		this.priority_num = priority_num;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}
}
