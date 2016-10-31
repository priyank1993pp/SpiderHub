package spiderhub.model.dao;

import java.util.List;

import spiderhub.model.ProjectType;

public interface ProjectTypeDao {

	List<ProjectType> getProjectType();
 	
	ProjectType getPerojectType(Integer id);
}
