package spiderhub.model.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import spiderhub.model.TaskStatus;
import spiderhub.model.dao.TaskStatusDao;

@Repository
public class TaskStatusDaoImpl implements TaskStatusDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public TaskStatus getTaskStatus(Integer id) {
		// TODO Auto-generated method stub
		return entityManager.find(TaskStatus.class, id);
	}
	
	
	
}
