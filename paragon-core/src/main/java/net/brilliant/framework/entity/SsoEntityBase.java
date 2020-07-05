package net.brilliant.framework.entity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

//TODO: consider to get inheritance from AuthenticateAccount
@MappedSuperclass
public abstract class SsoEntityBase extends RepoEntity /*RepoAuditable*/ {
	private static final long serialVersionUID = 8261894944163751162L;

	//@Pattern(regexp = "^[a-z0-9]*$|(anonymousUser)")
	@Column(name="sso_id", unique = true, nullable=false, length=50)
	private String ssoId;

	@Column(name = "password", nullable=false, length=160)
	@JsonIgnore
	private String password;

	@Column(name = "encrypt_alg", length=30)
	private String encryptAlgorithm;

	@Column(name = "email", unique = true, nullable=false, length=100)
	private String email;

	@Column(name = "locked")
	private Boolean locked = false;

	@Column(name = "system_admin")
	private Boolean systemAdmin = false;

	@Column(name = "activation_key", length=450)
	@JsonIgnore
	private String activationKey;

	@Column(name = "registered_date")
	private Date registeredDate;

	@Column(name = "activation_date")
	private Date activationDate;

	@Column(name = "issue_date")
	private Date issueDate;

	@Column(name = "reset_key", length=30)
	@JsonIgnore
	private String resetKey;

	@Column(name = "reset_date")
	private Date resetDate;

	@Column(name = "approved_sso_id", length=50)
	private String approvedSsoId;

	@Column(name = "approved_date")
	private Date approvedDate;

	public String getSsoId() {
		return ssoId;
	}

	public void setSsoId(String ssoId) {
		this.ssoId = ssoId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEncryptAlgorithm() {
		return encryptAlgorithm;
	}

	public void setEncryptAlgorithm(String encryptAlgorithm) {
		this.encryptAlgorithm = encryptAlgorithm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public Boolean getSystemAdmin() {
		return systemAdmin;
	}

	public void setSystemAdmin(Boolean systemAdmin) {
		this.systemAdmin = systemAdmin;
	}

	public String getActivationKey() {
		return activationKey;
	}

	public void setActivationKey(String activationKey) {
		this.activationKey = activationKey;
	}

	public Date getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getResetKey() {
		return resetKey;
	}

	public void setResetKey(String resetKey) {
		this.resetKey = resetKey;
	}

	public Date getResetDate() {
		return resetDate;
	}

	public void setResetDate(Date resetDate) {
		this.resetDate = resetDate;
	}

	public String getApprovedSsoId() {
		return approvedSsoId;
	}

	public void setApprovedSsoId(String approvedSsoId) {
		this.approvedSsoId = approvedSsoId;
	}

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public int compareTo(Object obj) {
		if (obj.hashCode() > hashCode())
			return 1;
		else if (obj.hashCode() < hashCode())
			return -1;
		else
			return 0;
	}
	
	//For the 
	public String getUsername() {
		return this.ssoId;
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
	
}