package spiderhub.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Component
public class FileController {
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

	@RequestMapping(value = "/manager/upload.html", method = RequestMethod.POST)
	public String uploadManager(@RequestParam MultipartFile file, @RequestParam("file") MultipartFile[] files)
			throws IllegalStateException, IOException {
		// save in web-inf/files
		file.transferTo(new File(getFileDirectory(), file.getOriginalFilename()));
		// to save into database
		// get the name from file file.getOriginalFilename() and save it in
		// database
		
		//for multiple files;
		return "manager/assignTask";
	}

	@RequestMapping("/download.html")
	public String download(HttpServletResponse response) throws IOException {

		// read in the file
		FileInputStream in = new FileInputStream(new File(getFileDirectory(), "HomeWork1.pdf"));
		OutputStream out = response.getOutputStream();
		// write it to response

		byte[] buffer = new byte[2048];
		int bytesRead;
		while ((bytesRead = in.read(buffer)) > 0) {
			out.write(buffer, 0, bytesRead);
		}
		in.close();

		return null;

	}
}
