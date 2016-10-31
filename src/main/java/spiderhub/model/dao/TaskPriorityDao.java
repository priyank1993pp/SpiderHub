package spiderhub.model.dao;

import java.util.List;

import spiderhub.model.TaskPriority;

public interface TaskPriorityDao {

	List<TaskPriority> getTaskPriority();
	
	TaskPriority getTaskpriority(Integer id);
	
}
