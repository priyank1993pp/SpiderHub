package spiderhub.model.dao;

import java.util.Date;
import java.util.List;

import spiderhub.model.TaskActivity;

public interface TaskActivityDao {
	TaskActivity getTaskActivity(Integer id);

	TaskActivity saveTaskActivity(TaskActivity taskActivity);

	List<TaskActivity> getTaskActivityFromRelatedTask(Integer tid);

	List<TaskActivity> getTakActivityByProject(Integer pid);

	List<TaskActivity> getTakActivityByTaskInsideProject(Integer pid, Integer tid);

	List<TaskActivity> getTakActivityWeeklyByTask(Integer tid, Date start, Date end);

	List<TaskActivity> getTakActivityWeeklyByProject(Integer pid, Date start, Date end);

	List<TaskActivity> getTakActivityWeeklyByUser(Integer uid, Date start, Date end);

}
