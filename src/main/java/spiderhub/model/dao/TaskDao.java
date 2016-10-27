package spiderhub.model.dao;

import java.util.List;

import spiderhub.model.Task;

public interface TaskDao {
	Task getTask(Integer id);

	List<Task> getTasks();

	Task saveTask(Task task);
}
