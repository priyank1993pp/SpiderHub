package spiderhub.model.dao.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spiderhub.model.TaskActivity;
import spiderhub.model.dao.TaskActivityDao;

@Repository
public class TaskActivityDaoImpl implements TaskActivityDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public TaskActivity getTaskActivity(Integer id) {
		String query = "from TaskActivity where id=:id";
		return entityManager.createQuery(query, TaskActivity.class).setParameter("id", id).getSingleResult();
	}

	@Override
	@Transactional
	public TaskActivity saveTaskActivity(TaskActivity taskActivity) {
		return entityManager.merge(taskActivity);

	}

	@Override
	public List<TaskActivity> getTaskActivityFromRelatedTask(Integer tid) {
		String query = "from TaskActivity where activityOfTask.id = :tId";
		return entityManager.createQuery(query, TaskActivity.class).setParameter("tId", tid).getResultList();
	}

	@Override
	public List<TaskActivity> getTakActivityWeekly(Date start, Date end) {
		
		return entityManager.createQuery("FROM TaskActivity AS t WHERE t.endTime BETWEEN :start AND :end " , TaskActivity.class)
				.setParameter("start", start)
				.setParameter("end", end)
				.getResultList();
	}

}
