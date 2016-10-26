package spiderhub.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import spiderhub.model.User;
import spiderhub.model.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public User saveUser(User user) {
		return entityManager.merge(user);
	}

	@Override
	public User getUserByUsername(String userName) {
		String query = "from User u left join fetch u.userRole " + "where lower(userName) = :userName ";

		// List<User> users = entityManager.createQuery(query,
		// User.class).setParameter("emailAddress", emailAddress.toLowerCase())
		// .getResultList();
		List<User> users = entityManager.createQuery(query, User.class).setParameter("userName", userName.toLowerCase())
				.getResultList();

		return users.size() == 0 ? null : users.get(0);
	}

	@Override
	public List<User> getUsertoAddInProject() {

		String query = "from User u where u.userRole = 1002";

		return entityManager.createQuery(query, User.class).getResultList();

	}
}
