package spiderhub.model.dao;

import java.util.List;

import spiderhub.model.UserRole;

public interface UserRoleDao {

	List<UserRole> getUserRoles();
	
	UserRole getUserRole(Integer id);
}
