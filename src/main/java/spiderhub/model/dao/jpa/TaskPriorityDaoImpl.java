package spiderhub.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;


import spiderhub.model.TaskPriority;
import spiderhub.model.dao.TaskPriorityDao;

@Repository
public class TaskPriorityDaoImpl implements TaskPriorityDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<TaskPriority> getTaskPriority() {
		return entityManager.createQuery("from TaskPriority order by id", TaskPriority.class).getResultList();
	}

	@Override
	public TaskPriority getTaskpriority(Integer id) {
		return entityManager.find(TaskPriority.class, id);
	}

	
	
}
