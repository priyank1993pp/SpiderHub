package spiderhub.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/*This model class for task comment both who doing task 
 * and who gave that task both can comment on task */

@Entity
@Table(name = "CommentsOnTask")
public class Comment implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int commentId;

	private String commentDesc;

	private boolean isDelete;

	private Date createDate;

	@ManyToOne
	User userComment;

	@ManyToOne
	Task taskComments;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getCommentDesc() {
		return commentDesc;
	}

	public void setCommentDesc(String commentDesc) {
		this.commentDesc = commentDesc;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public User getUserComment() {
		return userComment;
	}

	public void setUserComment(User userComment) {
		this.userComment = userComment;
	}

	public Task getTaskComments() {
		return taskComments;
	}

	public void setTaskComments(Task taskComments) {
		this.taskComments = taskComments;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
