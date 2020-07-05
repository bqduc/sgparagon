package net.brilliant.auth.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import net.brilliant.framework.entity.RepoAuditable;

/**
 * 
 * @author ducbq
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "aux_user_account_privilege")
public class UserAccountPrivilege extends RepoAuditable {
	private static final long serialVersionUID = 5170711397284237619L;

	@ManyToOne
	@JoinColumn(name = "user_account_id")
	private UserAccountProfile userAccount;

	@ManyToOne
	@JoinColumn(name = "authority_id")
	private Authority authority;

	public UserAccountProfile getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccountProfile userAccount) {
		this.userAccount = userAccount;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
}
