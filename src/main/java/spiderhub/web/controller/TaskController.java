package spiderhub.web.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spiderhub.model.Task;
import spiderhub.model.dao.ProjectDao;
import spiderhub.model.dao.TaskDao;
import spiderhub.model.dao.UserDao;

@Controller
public class TaskController {
	@Autowired
	private TaskDao taskDao;

	@Autowired
	private ProjectDao projectDao;

	@Autowired
	private UserDao userDao;
	
	@RequestMapping("/manager/projects/listTasks.html")
	public String managerlist(ModelMap models) {
		// get all users from databases and pass them to JSP

		List<Task> tasks = taskDao.getTasks();
		models.put("tasks", tasks);
		return "manager/projects/listTasks";
	}
	
	@RequestMapping("/member/projects/listTasks.html")
	public String memberlist(ModelMap models) {
		// get all users from databases and pass them to JSP

		List<Task> tasks = taskDao.getTasks();
		models.put("tasks", tasks);
		return "member/projects/listTasks";
	}
	
	@RequestMapping("/manager/projects/viewTask.html")
	// optional required = false
	public String managerview(@RequestParam(required = false) Integer id, ModelMap models) {
		// get user from database and pass it to JSP
		models.put("task", taskDao.getTask(id));
		return "manager/projects/viewTask";

	}
	
	@RequestMapping("/member/projects/viewTask.html")
	// optional required = false
	public String view(@RequestParam(required = false) Integer id, ModelMap models) {
		// get user from database and pass it to JSP
		models.put("task", taskDao.getTask(id));
		return "member/projects/viewTask";

	}
	
	@RequestMapping(value = "/manager/projects/addTask.html", method = RequestMethod.GET)
	public String add(ModelMap models) {
		models.put("task", new Task());// once this is done we no longer need to
										// add individual parameter
		return "manager/projects/addTask";
	}

	@RequestMapping(value = "/manager/projects/addTask.html", method = RequestMethod.POST)
	public String add(@ModelAttribute Task task) {

		// save user to database
		task.setCreateDate(new Date());
		task = taskDao.saveTask(task);
		// redirect to user list
		return "redirect:listTasks.html";
	}

	@RequestMapping(value = "/manager/projects/assignTask.html", method = RequestMethod.GET)
	public String assign(@RequestParam Integer id, ModelMap models) {
		models.put("task", new Task());
		models.put("users", userDao.getUsertoAddInProject());
		return "manager/projects/assignTask";
	}

	@RequestMapping(value = "/manager/projects/assignTask.html", method = RequestMethod.POST)
	public String assign(@RequestParam Integer id, @ModelAttribute Task task) {

		// save user to database
		task = taskDao.saveTask(task);
		// redirect to user list
		return "redirect:listTasks.html";
	}

}
