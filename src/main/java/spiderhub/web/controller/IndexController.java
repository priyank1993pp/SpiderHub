package spiderhub.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/index.html")
	public String index(ModelMap models) {
		models.put("user", "janak");
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

