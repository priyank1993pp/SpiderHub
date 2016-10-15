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
public class UserRole implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	private String userRole;

	private boolean isDelete;

	@OneToMany(mappedBy = "userRole")
	Set<User> userType;

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
		return userRole;
	}

	public void setUser_role(String user_role) {
		this.userRole = user_role;
	}

	public Set<User> getUser_type() {
		return userType;
	}

	public void setUser_type(Set<User> user_type) {
		this.userType = user_type;
	}
}
