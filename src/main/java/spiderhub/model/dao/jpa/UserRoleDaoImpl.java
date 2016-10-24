package spiderhub.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import spiderhub.model.UserRole;
import spiderhub.model.dao.UserRoleDao;

@Repository
public class UserRoleDaoImpl implements UserRoleDao {

	@PersistenceContext
    private EntityManager entityManager;
    
	@Override
	public List<UserRole> getUserRoles() {
		
		return entityManager.createQuery( "from UserRole order by id", UserRole.class )
	            .getResultList();
	}

	@Override
	public UserRole getUserRole(Integer id) {
		return (UserRole) entityManager.find( UserRole.class , id);
	}

	
}
