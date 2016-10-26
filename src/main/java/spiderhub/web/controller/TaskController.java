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

	@RequestMapping("/task/list.html")
	public String list(ModelMap models) {
		// get all users from databases and pass them to JSP

		List<Task> tasks = taskDao.getTasks();
		models.put("tasks", tasks);
		return "task/list";
	}

	@RequestMapping("/task/view.html")
	// optional required = false
	public String view(@RequestParam(required = false) Integer id, ModelMap models) {
		// get user from database and pass it to JSP
		models.put("task", taskDao.getTask(id));
		return "task/view";

	}

	@RequestMapping(value = "/task/add.html", method = RequestMethod.GET)
	public String add(ModelMap models) {
		models.put("task", new Task());// once this is done we no longer need to
										// add individual parameter
		return "task/add";
	}

	@RequestMapping(value = "/task/add.html", method = RequestMethod.POST)
	public String add(@ModelAttribute Task task) {

		// save user to database
		task.setCreateDate(new Date());
		task = taskDao.saveTask(task);
		// redirect to user list
		return "redirect:list.html";
	}

	@RequestMapping(value = "/task/assign.html", method = RequestMethod.GET)
	public String assign(@RequestParam Integer id, ModelMap models) {
		models.put("task", new Task());
		models.put("users", userDao.getUsertoAddInProject());
		return "task/assign";
	}

	@RequestMapping(value = "/task/assign.html", method = RequestMethod.POST)
	public String assign(@RequestParam Integer id, @ModelAttribute Task task) {

		// save user to database
		task = taskDao.saveTask(task);
		// redirect to user list
		return "redirect:list.html";
	}

}
