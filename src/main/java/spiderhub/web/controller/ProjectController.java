package spiderhub.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import spiderhub.model.Project;
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

	@RequestMapping(value = "/projects/add.html", method = RequestMethod.GET)
	public String add(ModelMap models) {
		models.put("project", new Project());
		return "projects/add";
	}

	@RequestMapping(value = "/projects/add.html", method = RequestMethod.POST)
	public String add(@ModelAttribute Project project) {
		project = projectDao.saveProject(project);
		return "redirect:list.html";
	}
}
