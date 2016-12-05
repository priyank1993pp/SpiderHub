package spiderhub.web.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import spiderhub.model.Comment;
import spiderhub.model.User;
import spiderhub.model.dao.CommentDao;
import spiderhub.model.dao.TaskDao;
import spiderhub.model.dao.UserDao;

@Controller
public class service {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	TaskDao taskDao;
	
	@Autowired
	CommentDao commentDao;

	

	
}
