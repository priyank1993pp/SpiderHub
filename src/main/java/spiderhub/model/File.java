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

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Task getTaskFiles() {
		return taskFiles;
	}

	public void setTaskFiles(Task taskFiles) {
		this.taskFiles = taskFiles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
