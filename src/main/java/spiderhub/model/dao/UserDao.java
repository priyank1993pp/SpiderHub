package spiderhub.model.dao;

import spiderhub.model.User;

public interface UserDao {
	
	User saveUser(User user);

	User getUserByUsername(String userName);
}
