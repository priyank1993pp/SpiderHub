package spiderhub.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import spiderhub.model.dao.FileDao;
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

	@Autowired
	private FileDao fileDao;

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
		// no files to show first time
		return "manager/assignTask";
	}

	@RequestMapping(value = "/manager/assignTask.html", method = RequestMethod.POST)
	public String assign(@RequestParam Integer tid, @RequestParam Integer pid, @RequestParam("action") String action,
			@ModelAttribute Task task, BindingResult bindingResult, HttpServletRequest request, SessionStatus status,
			ModelMap models) {

		if (action.equals("Assign")) {
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

	// file upload
	@RequestMapping(value = "/manager/uploadFileToAssigned.html", method = RequestMethod.GET)
	public String fileUpload(@RequestParam Integer tid, @RequestParam Integer pid, ModelMap models) {
		models.put("task", taskDao.getTask(tid));
		// for display of files
		models.put("fileModel", fileDao.getFilesAssignedToTask(tid));
		// no files to show first time
		return "manager/uploadFileToAssigned";
	}

	// file upload here
	@RequestMapping(value = "/manager/uploadFileToAssigned.html", method = RequestMethod.POST)
	public String fileUpload(@RequestParam Integer tid, @RequestParam Integer pid,
			@RequestParam("action") String action, @ModelAttribute Task task, BindingResult bindingResult,
			HttpServletRequest request, SessionStatus status, ModelMap models,
			@RequestParam MultipartFile file/*
											 * , @ModelAttribute File fileModel
											 */) throws IllegalStateException, IOException {
		System.out.println("***************Inside if");

		if (action.equals("Upload")) {
			// handle upload
			// System.out.println("***************Inside if");
			models.put("task", taskDao.getTask(tid));
			Project temp = projectDao.getProject(pid);
			models.put("users", temp.getUsersRelatedProject());
			models.put("priority", taskpriorityDao.getTaskPriority());

			// for display of files
			models.put("fileModel", fileDao.getFilesAssignedToTask(tid));

			// models.put("users", userDao.getUsertoAddInProject());

			String fileName = "";
			String filePath = "";
			String fileType = "";
			String fileSize = "";
			// save in web-inf/files
			if (file.getOriginalFilename() != null) {
				String[] fileNameSplit = file.getOriginalFilename().split("[.]");
				fileName = fileNameSplit[0];
				fileType = fileNameSplit[1];
				// for testing fileType is fileName
				fileSize = String.valueOf(file.getSize());
				filePath = context.getRealPath("/WEB-INF/files");
				file.transferTo(new File(getFileDirectory(), file.getOriginalFilename()));
			}

			// to save into database
			spiderhub.model.File fileModel = new spiderhub.model.File();
			fileModel.setDelete(false);
			fileModel.setFileName(fileName);
			fileModel.setFilePath(filePath);
			fileModel.setFileSize(fileSize);
			fileModel.setFileType(fileType);
			fileModel.setUploadDate(new Date());
			fileModel.setTaskFiles(taskDao.getTask(tid));
			fileDao.saveFile(fileModel);
			// get the name from file file.getOriginalFilename() and save it in
			// database

			// for multiple files;
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

	@RequestMapping("/member/viewTask.html")
	// optional required = false
	public String memberView(@RequestParam Integer tid, ModelMap models) {
		// get user from database and pass it to JSP
		models.put("task", taskDao.getTask(tid));
		// for display of files
		models.put("fileModel", fileDao.getFilesAssignedToTask(tid));
		return "member/viewTask";

	}

	@RequestMapping("/member/download.html")
	public String download(@RequestParam String file, HttpServletResponse response) throws IOException {

		// read in the file
		String fullPath = "/" + file;

		FileInputStream in = new FileInputStream(new File(getFileDirectory(), fullPath));
		OutputStream out = response.getOutputStream();
		// write it to response
		System.out.println("fileDownload--------*********");
		byte[] buffer = new byte[2048];
		int bytesRead;
		while ((bytesRead = in.read(buffer)) > 0) {
			out.write(buffer, 0, bytesRead);
		}
		in.close();

		return null;

	}

}
