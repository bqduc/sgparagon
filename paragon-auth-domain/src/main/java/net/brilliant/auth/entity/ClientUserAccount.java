/**
 * 
 */
package net.brilliant.auth.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.brilliant.framework.entity.RepoAuditable;

/**
 * @author bqduc
 *
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "aux_client_user_account")
@EqualsAndHashCode(callSuper = true)
public class ClientUserAccount extends RepoAuditable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -78954046194922264L;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "user_account_id")
	private UserAccountProfile userAccount;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "last_approved_user_id")
	private UserAccountProfile lastApprovedBy;

	@Column(name = "last_approved_date")
	private Date lastApprovedDate;

	public UserAccountProfile getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccountProfile userAccount) {
		this.userAccount = userAccount;
	}

	public UserAccountProfile getLastApprovedBy() {
		return lastApprovedBy;
	}

	public void setLastApprovedBy(UserAccountProfile lastApprovedBy) {
		this.lastApprovedBy = lastApprovedBy;
	}

	public Date getLastApprovedDate() {
		return lastApprovedDate;
	}

	public void setLastApprovedDate(Date lastApprovedDate) {
		this.lastApprovedDate = lastApprovedDate;
	}

}
