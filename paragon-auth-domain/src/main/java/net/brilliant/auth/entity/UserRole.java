package net.brilliant.auth.entity;
/*package net.paramount.auth.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.paramount.framework.entity.ObjectBase;

*//**
 * 
 * @author ducbq
 *//*
@Entity
@Table(name = "aux_user_role")
public class UserRole extends ObjectBase {
	*//**
	 * 
	 *//*
	private static final long serialVersionUID = -5738835622345821174L;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private AuxUserProfile user;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Authority role;

	public AuxUserProfile getUser() {
		return user;
	}

	public void setUser(AuxUserProfile user) {
		this.user = user;
	}

	public Authority getRole() {
		return role;
	}

	public void setRole(Authority role) {
		this.role = role;
	}
}
*/