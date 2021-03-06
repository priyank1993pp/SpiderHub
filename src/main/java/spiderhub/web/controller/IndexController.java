package spiderhub.web.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
	TaskDao taskDao;

	@RequestMapping("/index.html")
	public String index(ModelMap models) {
		models.put("user", "janak");
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			User User = (User) auth.getPrincipal();
			int id = User.getId();
			models.put("complete", taskDao.getNoOfCompletedTask(id));
			models.put("remaining", taskDao.getNoOfOngoingTask(id));
			System.out.println("remaining" + taskDao.getNoOfOngoingTask(id));
			models.put("totalTasks", taskDao.getTotalNofTask(id));
			models.put("high", taskDao.getAllTaskAccordingToHIGHPriorityWithinAProject(id));
			models.put("medium", taskDao.getAllTaskAccordingToMEDIUMPriorityWithinAProject(id));
			models.put("low", taskDao.getAllTaskAccordingToLOWPriorityWithinAProject(id));
			
			Calendar now = Calendar.getInstance();
			String year = String.valueOf(now.get(Calendar.YEAR));
			String month = String.valueOf(now.get(Calendar.MONTH));
			Map<String, Long> map = new HashMap<String, Long>();
			int currentDate = now.get(Calendar.DATE);
			for (int i = 1; i <= currentDate; i++) {
				now.set(Calendar.DATE, i);
				Date d = now.getTime();
				String day = String.valueOf(i);
				String dateString = "new Date("+ year  +", "+ month +", "+  day  +")";
				map.put(dateString, taskDao.getCountOfOngoingTaskOfMemberByDate(id, d));
			}
			for (Map.Entry<String, Long> entry : map.entrySet()) {
			    String key = entry.getKey();
			    Long value = entry.getValue();
			    System.out.println(key +"      "+value);
			  
			}
			models.put("list", map);

		} catch (Exception e) {
		}
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
