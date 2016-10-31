package spiderhub.model.dao;

import spiderhub.model.TaskStatus;

public interface TaskStatusDao {
	
	TaskStatus getTaskStatus(Integer id);

}
