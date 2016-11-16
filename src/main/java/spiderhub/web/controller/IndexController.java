package spiderhub.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import spiderhub.model.User;
import spiderhub.model.dao.TaskDao;

@Controller
public class IndexController {
	
	@Autowired
    private	TaskDao taskDao;
	
	@RequestMapping("/index.html")
	public String index(ModelMap models) {
		models.put("user", "janak");
		try{Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User User = (User)auth.getPrincipal();
		int id = User.getId();
		models.put("com", 9);
		models.put("rem", 2);
		models.put("noOfCompletedTask",(int)(long)taskDao.getNoOfCompletedTask(id));
		models.put("noOfProcessingTask",(int)(long)taskDao.getNoOfOngoingTask(id));
		models.put("totalTasks",taskDao.getTotalNofTask(id));}catch(Exception e){}
		return "index";
	}

	@RequestMapping("/projects/index.html")
	public String index1(ModelMap models) {
		models.put("user", "janak");
		return "index";
	}

	@RequestMapping("/task/index.html")
	public String index2(ModelMap models) {
		models.put("user", "janak");
		return "index";
	}
}

