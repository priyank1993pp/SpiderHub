package spiderhub.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import spiderhub.model.Project;
import spiderhub.model.dao.ProjectDao;
import spiderhub.model.dao.UserDao;

@Controller
@SessionAttributes("project")
public class ProjectController {
	@Autowired
	private ProjectDao projectDao;

	@Autowired
	private UserDao userDao;

	@RequestMapping("/projects/list.html")
	public String projects(ModelMap models) {
		models.put("projects", projectDao.getProjects());
		return "projects/list";
	}

	@RequestMapping("/projects/view.html")
	// optional required = false
	public String view(@RequestParam(required = false) Integer id, ModelMap models) {
		// get user from database and pass it to JSP
		models.put("project", projectDao.getProject(id));
		return "projects/view";

	}



	@RequestMapping(value = "/projects/add.html", method = RequestMethod.GET)
	public String add(ModelMap models) {
		models.put("project", new Project());
		return "projects/add";
	}

	@RequestMapping(value = "/projects/add.html", method = RequestMethod.POST)
	public String add(@ModelAttribute Project project) {
		project.setCreatedDate(new Date());
		project = projectDao.saveProject(project);
		return "redirect:list.html";
	}

	@RequestMapping(value = "/projects/edit.html", method = RequestMethod.GET)
	public String edit(@RequestParam Integer id, ModelMap models) {
		models.put("project", projectDao.getProject(id));
		return "projects/edit";
	}

	@RequestMapping(value = "/projects/edit.html", method = RequestMethod.POST)
	public String edit(@ModelAttribute Project project, SessionStatus status) {
		project = projectDao.saveProject(project);
		status.setComplete();
		return "redirect:list.html";
	}

	@RequestMapping(value = "/projects/disable.html")
	public String disable(@RequestParam Integer id) {
		Project deleteproject = projectDao.getProject(id);

		deleteproject.setDelete(true);
		deleteproject = projectDao.saveProject(deleteproject);

		return "redirect:list.html";
	}

	@RequestMapping(value = "/projects/addUser.html", method = RequestMethod.GET)
	public String addUser(@RequestParam Integer id, ModelMap models) {
		models.put("users", userDao.getUsertoAddInProject());
		models.put("project", projectDao.getProject(id));
		return "projects/addUser";
	}

	@RequestMapping(value = "/projects/addUser.html", method = RequestMethod.POST)
	public String addUser(@ModelAttribute Project project) {
		project = projectDao.saveProject(project);
		return "redirect:list.html";
	}
}
