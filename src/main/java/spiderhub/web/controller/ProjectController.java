package spiderhub.web.controller;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import spiderhub.model.Project;
import spiderhub.model.User;
import spiderhub.model.dao.ProjectDao;
import spiderhub.model.dao.ProjectTypeDao;
import spiderhub.model.dao.TaskDao;
import spiderhub.model.dao.UserDao;

@Controller
@SessionAttributes("project")
public class ProjectController {
	@Autowired
	private ProjectDao projectDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private ProjectTypeDao projecttypeDao;

	@Autowired
	private TaskDao taskDao;

	Set<User> users = new HashSet<>();

	@RequestMapping("/admin/listProjects.html")
	public String adminprojects(ModelMap models) {

		models.put("projects", projectDao.getProjects());
		return "admin/listProjects";
	}

	@RequestMapping("/manager/listProjects.html")
	public String managerprojects(ModelMap models) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User User = (User) auth.getPrincipal();
		models.put("projects", projectDao.getProjectofManager(User.getId()));
		return "manager/listProjects";
	}

	@RequestMapping("/member/listProjects.html")
	public String projects(ModelMap models) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User User = (User) auth.getPrincipal();
		int id = User.getId();
		models.put("projects", userDao.getUser(id).getProjects());
		return "member/listProjects";
	}

	@RequestMapping("/admin/viewProject.html")
	// optional required = false
	public String adminview(@RequestParam(required = false) Integer id, ModelMap models) {
		// get user from database and pass it to JSP
		models.put("project", projectDao.getProject(id));
		return "admin/viewProject";

	}

	@RequestMapping("/manager/viewProject.html")
	// optional required = false
	public String managerview(@RequestParam(required = false) Integer id, ModelMap models) {
		// get user from database and pass it to JSP
		models.put("project", projectDao.getProject(id));
		models.put("tasks", taskDao.getTaskByProject(id));
		models.put("progress", taskDao.getNoOfCompletedTaskinProject(id) * 100 / taskDao.getTotalNofTaskinProject(id));
		return "manager/viewProject";

	}

	@RequestMapping("/admin/reportgeneration.html")
	public String rport(@RequestParam Integer id) {

		return null;

	}

	@RequestMapping("/member/viewProject.html")
	// optional required = false
	public String view(@RequestParam Integer id, ModelMap models) {
		// get user from database and pass it to JSP
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User User = (User) auth.getPrincipal();
		int uid = User.getId();
		System.out.println(uid);
		System.out.println(id);
		models.put("project", projectDao.getProject(id));
		models.put("task", taskDao.getTaskOfMemberByProject(uid, id));
		return "member/viewProject";

	}

	@RequestMapping(value = "/manager/addProject.html", method = RequestMethod.GET)
	public String manageradd(ModelMap models) {
		models.put("project", new Project());
		models.put("projecttype", projecttypeDao.getProjectType());
		return "manager/addProject";
	}

	@RequestMapping(value = "/manager/addProject.html", method = RequestMethod.POST)
	public String manageradd(@ModelAttribute Project project, HttpServletRequest request) {

		project.setProjectType(projecttypeDao.getPerojectType(Integer.parseInt(request.getParameter("projecttype"))));
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User User = (User) auth.getPrincipal();
		int userId = User.getId();
		project.setCreatedUser(userDao.getUser(userId));
		project.setCreatedDate(new Date());
		project = projectDao.saveProject(project);
		return "redirect:listProjects.html";
	}

	@RequestMapping(value = "/manager/editProject.html", method = RequestMethod.GET)
	public String edit(@RequestParam Integer id, ModelMap models) {
		models.put("project", projectDao.getProject(id));
		return "manager/editProject";
	}

	@RequestMapping(value = "/manager/editProject.html", method = RequestMethod.POST)
	public String edit(@ModelAttribute Project project, SessionStatus status) {
		project = projectDao.saveProject(project);
		status.setComplete();
		return "redirect:listProjects.html";
	}

	@RequestMapping(value = "/admin/disable.html")
	public String admindisable(@RequestParam Integer id) {
		Project deleteproject = projectDao.getProject(id);

		deleteproject.setDelete(true);
		deleteproject = projectDao.saveProject(deleteproject);

		return "redirect:listProjects.html";
	}

	@RequestMapping(value = "/manager/disable.html")
	public String managerdisable(@RequestParam Integer id) {
		Project deleteproject = projectDao.getProject(id);

		deleteproject.setDelete(true);
		deleteproject = projectDao.saveProject(deleteproject);

		return "redirect:listProjects.html";
	}

	@RequestMapping(value = "/manager/addUserInProject.html", method = RequestMethod.GET)
	public String addUser(@RequestParam Integer id, ModelMap models) {
		models.put("users", userDao.getUserToaddInProject());
		models.put("project", projectDao.getProject(id));
		return "manager/addUserInProject";
	}

	@RequestMapping(value = "/manager/addUserInProject.html", method = RequestMethod.POST)
	public String addUser(@ModelAttribute Project project, HttpServletRequest request) {
		String[] chkSms = request.getParameterValues("chksms");
		int[] value = new int[chkSms.length];

		for (int i = 0; i < chkSms.length; i++)
			value[i] = Integer.parseInt(chkSms[i]);

		System.out.println("adding user to project" + chkSms);

		for (int i = 0; i < value.length; i++) {
			users.add(userDao.getUser(value[i]));
		}

		project.setUsersRelatedProject(users);
		project = projectDao.saveProject(project);
		return "redirect:listProjects.html";

	}
}
