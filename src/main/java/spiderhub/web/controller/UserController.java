package spiderhub.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spiderhub.model.User;
import spiderhub.model.dao.UserDao;
import spiderhub.model.dao.UserRoleDao;

@Controller
public class UserController {

	@Autowired
	UserDao userDao;

	@Autowired
	UserRoleDao roleDao;

	@RequestMapping(value = "/userRegistration.html", method = RequestMethod.GET)
	public String register(ModelMap models) {
		models.put("user", new User());
		models.put("UserRole", roleDao.getUserRoles());
		return "userRegistration";
	}

	@RequestMapping(value = "/userRegistration.html", method = RequestMethod.POST)
	public String register(@ModelAttribute User user, BindingResult bindingResult, ModelMap models,
			HttpServletRequest request) {

		user.setUserRole(roleDao.getUserRole(Integer.parseInt(request.getParameter("role"))));
		user.setDelete(false);
		user.setCreateDate(new Date());
		userDao.saveUser(user);
		models.addAttribute("modalShow", "Saved");
		return "index";
	}
}
