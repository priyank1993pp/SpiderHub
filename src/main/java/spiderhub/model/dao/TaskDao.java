package spiderhub.model.dao;

import java.util.List;

import spiderhub.model.Task;

public interface TaskDao {
	Task getTask(Integer id);

	List<Task> getTasks();

	Task saveTask(Task task);
	
	List<Task> getTaskByProject(Integer id);
	
	List<Task> getTaskOfMemberByProject(Integer uId , Integer pId);
	
	//to get no of ongoing task
	long getNoOfOngoingTask(Integer uId);
	
	//to get No Of Completed Task
	
	long getNoOfCompletedTask(Integer uId);
	
	
	//To get total no of task
	
	long getTotalNofTask(Integer uId);
	
}
