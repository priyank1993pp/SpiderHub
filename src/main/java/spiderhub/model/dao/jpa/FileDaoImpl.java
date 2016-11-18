package spiderhub.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spiderhub.model.File;
import spiderhub.model.dao.FileDao;

@Repository
public class FileDaoImpl implements FileDao{

	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public File getFile(Integer id) {
		return entityManager.find(File.class, id);

	}

	
	@Override
	@Transactional
	public File saveFile(File file) {
		return entityManager.merge(file);
	}

	@Override
	public List<File> getFiles() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from File order by id", File.class).getResultList();
	}

	@Override
	public List<File> getFilesAssignedToTask(Integer id) {
		
		String query = "from File where taskFiles.id = :tId";
		return entityManager.createQuery(query , File.class).setParameter("tId", id).getResultList();
	}

}
