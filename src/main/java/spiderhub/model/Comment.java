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

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Date getCreate_date() {
		return createDate;
	}

	public void setCreate_date(Date create_date) {
		this.createDate = create_date;
	}

	public int getCmt_id() {
		return commentId;
	}

	public void setCmt_id(int cmt_id) {
		this.commentId = cmt_id;
	}

	public String getCmt_desc() {
		return commentDesc;
	}

	public void setCmt_desc(String cmt_desc) {
		this.commentDesc = cmt_desc;
	}

	public User getUser_comment() {
		return userComment;
	}

	public void setUser_comment(User user_comment) {
		this.userComment = user_comment;
	}

	public Task getTask_comments() {
		return taskComments;
	}

	public void setTask_comments(Task task_comments) {
		this.taskComments = task_comments;
	}
}
