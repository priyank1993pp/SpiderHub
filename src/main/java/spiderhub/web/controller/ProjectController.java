package spiderhub.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import spiderhub.model.dao.ProjectDao;


@Controller
@SessionAttributes("project")
public class ProjectController {
	@Autowired
	private ProjectDao projectDao;
	
	@RequestMapping("/projects/list.html")
	public String projects(ModelMap models) {
		models.put("projects", projectDao.getProjects());
		return "projects/list";
	}
}
