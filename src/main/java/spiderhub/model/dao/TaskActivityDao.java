package spiderhub.model.dao;

import java.util.List;

import spiderhub.model.TaskActivity;

public interface TaskActivityDao {
	TaskActivity getTaskActivity(Integer id);

	TaskActivity saveTaskActivity(TaskActivity taskActivity);

	List<TaskActivity> getTaskActivityFromRelatedTask(Integer tid);

}
