package spiderhub.model.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spiderhub.model.TaskActivity;
import spiderhub.model.dao.TaskActivityDao;

@Repository
public class TaskActivityDaoImpl implements TaskActivityDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	

	@Override
	public TaskActivity getTaskActivity(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	@Transactional
	public TaskActivity saveTaskActivity(TaskActivity taskActivity) {
		// TODO Auto-generated method stub
		return null;
	}

}
