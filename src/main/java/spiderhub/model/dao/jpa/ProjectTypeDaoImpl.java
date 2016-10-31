package spiderhub.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import spiderhub.model.ProjectType;
import spiderhub.model.dao.ProjectTypeDao;

@Repository
public class ProjectTypeDaoImpl implements ProjectTypeDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<ProjectType> getProjectType() {

		return entityManager.createQuery("from ProjectType order by id", ProjectType.class).getResultList();
	}

	@Override
	public ProjectType getPerojectType(Integer id) {
		
		return entityManager.find(ProjectType.class, id);
	}

}
