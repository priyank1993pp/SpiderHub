package spiderhub.web.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	@RequestMapping("/admin/projects/listProjects.html")
	public String adminprojects(ModelMap models) {
		models.put("projects", projectDao.getProjects());
		return "admin/projects/listProjects";
	}
	
	@RequestMapping("/manager/projects/listProjects.html")
	public String managerprojects(ModelMap models) {
		models.put("projects", projectDao.getProjects());
		return "manager/projects/listProjects";
	}
	
	@RequestMapping("/member/projects/listProjects.html")
	public String projects(ModelMap models) {
		models.put("projects", projectDao.getProjects());
		return "member/projects/listProjects";
	}

	@RequestMapping("/admin/projects/viewProject.html")
	// optional required = false
	public String adminview(@RequestParam(required = false) Integer id, ModelMap models) {
		// get user from database and pass it to JSP
		models.put("project", projectDao.getProject(id));
		return "admin/projects/viewProject";

	}
	
	@RequestMapping("/manager/projects/viewProject.html")
	// optional required = false
	public String managerview(@RequestParam(required = false) Integer id, ModelMap models) {
		// get user from database and pass it to JSP
		models.put("project", projectDao.getProject(id));
		return "manager/projects/viewProject";

	}
	
	@RequestMapping("/member/projects/viewProject.html")
	// optional required = false
	public String view(@RequestParam(required = false) Integer id, ModelMap models) {
		// get user from database and pass it to JSP
		models.put("project", projectDao.getProject(id));
		return "member/projects/viewProject";

	}
	
	@RequestMapping(value = "/manager/projects/addProject.html", method = RequestMethod.GET)
	public String manageradd(ModelMap models) {
		models.put("project", new Project());
		return "manager/projects/addProject";
	}

	@RequestMapping(value = "/manager/projects/addProject.html", method = RequestMethod.POST)
	public String manageradd(@ModelAttribute Project project) {
		project.setCreatedDate(new Date());
		project = projectDao.saveProject(project);
		return "redirect:listProjects.html";
	}
	
	@RequestMapping(value = "/manager/projects/editProject.html", method = RequestMethod.GET)
	public String edit(@RequestParam Integer id, ModelMap models) {
		models.put("project", projectDao.getProject(id));
		return "manager/projects/editProject";
	}

	@RequestMapping(value = "/manager/projects/editProject.html", method = RequestMethod.POST)
	public String edit(@ModelAttribute Project project, SessionStatus status) {
		project = projectDao.saveProject(project);
		status.setComplete();
		return "redirect:listProject.html";
	}

	@RequestMapping(value = "/admin/projects/disable.html")
	public String admindisable(@RequestParam Integer id) {
		Project deleteproject = projectDao.getProject(id);

		deleteproject.setDelete(true);
		deleteproject = projectDao.saveProject(deleteproject);

		return "redirect:listProjects.html";
	}
	
	@RequestMapping(value = "/manager/projects/disable.html")
	public String managerdisable(@RequestParam Integer id) {
		Project deleteproject = projectDao.getProject(id);

		deleteproject.setDelete(true);
		deleteproject = projectDao.saveProject(deleteproject);

		return "redirect:listProjects.html";
	}
	
	@RequestMapping(value = "/manager/projects/addUserInProject.html", method = RequestMethod.GET)
	public String addUser(@RequestParam Integer id, ModelMap models) {
		models.put("users", userDao.getUsertoAddInProject());
		models.put("project", projectDao.getProject(id));
		return "manager/projects/addUserInProject";
	}

	@RequestMapping(value = "/manager/projects/addUserInProject.html", method = RequestMethod.POST)
	public String addUser(@ModelAttribute Project project) {
		project = projectDao.saveProject(project);
		return "redirect:listProjects.html";
	}
}
