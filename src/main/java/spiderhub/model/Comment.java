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
	private int cmt_id;

	private String cmt_desc;

	private boolean isDelete;

	private Date create_date;

	@ManyToOne
	User user_comment;

	@ManyToOne
	Task task_comments;

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public int getCmt_id() {
		return cmt_id;
	}

	public void setCmt_id(int cmt_id) {
		this.cmt_id = cmt_id;
	}

	public String getCmt_desc() {
		return cmt_desc;
	}

	public void setCmt_desc(String cmt_desc) {
		this.cmt_desc = cmt_desc;
	}

	public User getUser_comment() {
		return user_comment;
	}

	public void setUser_comment(User user_comment) {
		this.user_comment = user_comment;
	}

	public Task getTask_comments() {
		return task_comments;
	}

	public void setTask_comments(Task task_comments) {
		this.task_comments = task_comments;
	}
}
