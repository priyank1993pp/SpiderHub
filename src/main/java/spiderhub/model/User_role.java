package spiderhub.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//This class is for describing user role. It shows user is manager or member.

@Entity
@Table(name = "user_role")
public class User_role implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	private String user_role;

	private boolean isDelete;

	@OneToMany(mappedBy = "user_role")
	Set<User> user_type;

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	public Set<User> getUser_type() {
		return user_type;
	}

	public void setUser_type(Set<User> user_type) {
		this.user_type = user_type;
	}
}
