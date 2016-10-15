package spiderhub.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*This model class for file which will upload by manager and members.*/

@Entity
@Table(name = "Files")
public class File implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int fileId;

	private String fileName;

	private String fileType;

	private String fileSize;

	private String filePath;

	private Date uploadDate;

	private boolean isDelete;

	@ManyToOne
	Task taskFiles;

	public Date getUpload_date() {
		return uploadDate;
	}

	public void setUpload_date(Date upload_date) {
		this.uploadDate = upload_date;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public String getFile_path() {
		return fileName;
	}

	public void setFile_path(String file_path) {
		this.fileName = file_path;
	}

	public int getFile_id() {
		return fileId;
	}

	public void setFile_id(int file_id) {
		this.fileId = file_id;
	}

	public String getFile_name() {
		return fileName;
	}

	public void setFile_name(String file_name) {
		this.fileName = file_name;
	}

	public String getFile_type() {
		return fileType;
	}

	public void setFile_type(String file_type) {
		this.fileType = file_type;
	}

	public String getFile_size() {
		return fileSize;
	}

	public void setFile_size(String file_size) {
		this.fileSize = file_size;
	}

	public Task getTask_files() {
		return taskFiles;
	}

	public void setTask_files(Task task_files) {
		this.taskFiles = task_files;
	}
}
