package spiderhub.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spiderhub.model.Task;
import spiderhub.model.dao.TaskDao;

@Repository
public class TaskDaoImpl implements TaskDao {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Task getTask(Integer id) {
		return entityManager.find(Task.class, id);
	}

	@Override
	public List<Task> getTasks() {
		return entityManager.createQuery("from Task order by id", Task.class).getResultList();
	}

	@Override
	@Transactional
	public Task saveTask(Task task) {
		// TODO Auto-generated method stub
		return entityManager.merge(task);
	}
}
