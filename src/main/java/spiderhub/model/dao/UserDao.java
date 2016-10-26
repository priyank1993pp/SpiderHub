package spiderhub.model.dao;

import java.util.List;

import spiderhub.model.User;

public interface UserDao {

	User saveUser(User user);

	User getUserByUsername(String userName);

	List<User> getUsertoAddInProject();
}
