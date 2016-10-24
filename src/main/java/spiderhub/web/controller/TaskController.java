package spiderhub.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spiderhub.model.Task;
import spiderhub.model.dao.TaskDao;

@Controller
public class TaskController {
	@Autowired
	private TaskDao taskDao;

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

	@RequestMapping("/task/view/{id}.html")
	public String view1(@PathVariable Integer id, ModelMap models) {
		// get user from database and pass it to JSP
		return view(id, models);
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
		task = taskDao.saveTask(task);
		// redirect to user list
		return "redirect:list.html";
	}
}
