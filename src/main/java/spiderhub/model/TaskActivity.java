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

	public Date getStart_time() {
		return startTime;
	}

	public void setStart_time(Date start_time) {
		this.startTime = start_time;
	}

	public Date getEnd_time() {
		return endTime;
	}

	public void setEnd_time(Date end_time) {
		this.endTime = end_time;
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
}
