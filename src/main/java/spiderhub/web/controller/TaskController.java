package spiderhub.web.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import spiderhub.model.Project;
import spiderhub.model.Task;
import spiderhub.model.dao.ProjectDao;
import spiderhub.model.dao.TaskDao;
import spiderhub.model.dao.TaskPriorityDao;
import spiderhub.model.dao.TaskStatusDao;
import spiderhub.model.dao.UserDao;

@Controller
public class TaskController {

	@Autowired
	private TaskDao taskDao;

	@Autowired
	private ProjectDao projectDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private TaskPriorityDao taskpriorityDao;

	@Autowired
	private TaskStatusDao taskstatusDao;

	/*
	 * Member variables for file upload
	 */
	@Autowired
	private ServletContext context;

	private static final int BUFFER_SIZE = 4096;
	private String filePath = "/WEB-INF/files/";

	/*
	 * helper method for file upload to get the file path
	 */

	private File getFileDirectory() {
		String path = context.getRealPath("/WEB-INF/files");
		return new File(path);
	}

	@RequestMapping("/manager/listTasks.html")
	public String managerlist(ModelMap models) {
		// get all users from databases and pass them to JSP

		List<Task> tasks = taskDao.getTasks();
		models.put("tasks", tasks);
		return "manager/listTasks";
	}

	@RequestMapping("/manager/viewTask.html")
	// optional required = false
	public String managerview(@RequestParam(required = false) Integer id, ModelMap models) {
		// get user from database and pass it to JSP
		models.put("task", taskDao.getTask(id));
		return "manager/viewTask";

	}

	@RequestMapping(value = "/manager/addTask.html", method = RequestMethod.GET)
	public String add(ModelMap models) {
		models.put("task", new Task());
		return "manager/addTask";
	}

	@RequestMapping(value = "/manager/addTask.html", method = RequestMethod.POST)
	public String add(@ModelAttribute Task task, @RequestParam Integer id) {

		// save user to database
		task.setProjectTasks(projectDao.getProject(id));
		/* task.setCreateDate(new Date()); */
		task = taskDao.saveTask(task);
		// redirect to user list

		return "redirect:viewProject.html?id=" + id;
	}

	@RequestMapping(value = "/manager/assignTask.html", method = RequestMethod.GET)
	public String assign(@RequestParam Integer tid, @RequestParam Integer pid, ModelMap models) {
		models.put("task", taskDao.getTask(tid));
		Project temp = projectDao.getProject(pid);
		models.put("users", temp.getUsersRelatedProject());
		models.put("priority", taskpriorityDao.getTaskPriority());
		return "manager/assignTask";
	}

	// file upload here
	@RequestMapping(value = "/manager/assignTask.html", method = RequestMethod.POST)
	public String assign(@RequestParam Integer tid, @RequestParam Integer pid, @RequestParam("action") String action,
			@ModelAttribute Task task, BindingResult bindingResult, HttpServletRequest request, SessionStatus status,
			ModelMap models, @RequestParam MultipartFile file) throws IllegalStateException, IOException {

		if (action.equals("Upload")) {
			// handle upload

			models.put("task", taskDao.getTask(tid));
			Project temp = projectDao.getProject(pid);
			models.put("users", temp.getUsersRelatedProject());
			models.put("priority", taskpriorityDao.getTaskPriority());

			// models.put("users", userDao.getUsertoAddInProject());

			// save in web-inf/files
			file.transferTo(new File(getFileDirectory(), file.getOriginalFilename()));
			// to save into database
			// get the name from file file.getOriginalFilename() and save it in
			// database

			// for multiple files;
			return "manager/assignTask";
		} else if (action.equals("Assign")) {
			// handle renew

			task.setProjectTasks(projectDao.getProject(pid));
			task.setUserTasks(userDao.getUser(Integer.parseInt(request.getParameter("user"))));
			task.setTaskPriority(taskpriorityDao.getTaskpriority(Integer.parseInt(request.getParameter("priority"))));
			task.setStatusTasks(taskstatusDao.getTaskStatus(1));
			task.setStartDate(new Date());

			/*
			 * task.setEndDate(SimpleDateFormat.parse(request.getParameter(
			 * "enddate" )));
			 */

			task = taskDao.saveTask(task);
			status.setComplete();
			// redirect to user list
			return "redirect:viewProject.html?id=" + pid;
		}
		return null;

	}

	@RequestMapping(value = "/member/doneTask.html")
	public String managerdisable(@RequestParam Integer tid) {

		Task changestatusoftask = taskDao.getTask(tid);

		changestatusoftask.setStatusTasks(taskstatusDao.getTaskStatus(2));

		changestatusoftask = taskDao.saveTask(changestatusoftask);

		return "redirect:listProjects.html";
	}
}
