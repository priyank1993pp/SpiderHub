package spiderhub.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//This class is for time-stamp in task It describes which actions are done on 
//particular task.

@Entity
@Table(name = "task_Activity")
public class TaskActivity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	private Date startTime;

	private Date endTime;

	private boolean complete;

	@ManyToOne
	Task activityOfTask;

	@ManyToOne
	User activityOfTaskByUser;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public Task getActivityOfTask() {
		return activityOfTask;
	}

	public void setActivityOfTask(Task activityOfTask) {
		this.activityOfTask = activityOfTask;
	}

	public User getActivityOfTaskByUser() {
		return activityOfTaskByUser;
	}

	public void setActivityOfTaskByUser(User activityOfTaskByUser) {
		this.activityOfTaskByUser = activityOfTaskByUser;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
