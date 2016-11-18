package spiderhub.model.dao;

import spiderhub.model.TaskActivity;

public interface TaskActivityDao {
	TaskActivity getTaskActivity(Integer id);

	TaskActivity saveTaskActivity(TaskActivity taskActivity);
}
