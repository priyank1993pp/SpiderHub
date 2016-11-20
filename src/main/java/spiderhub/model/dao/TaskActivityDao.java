package spiderhub.model.dao;

import java.util.Date;
import java.util.List;

import spiderhub.model.TaskActivity;

public interface TaskActivityDao {
	TaskActivity getTaskActivity(Integer id);

	TaskActivity saveTaskActivity(TaskActivity taskActivity);

	List<TaskActivity> getTaskActivityFromRelatedTask(Integer tid);
	
	List<TaskActivity> getTakActivityWeekly(Date start , Date end);

}
