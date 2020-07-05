package net.brilliant.auth.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import net.brilliant.framework.entity.RepoEntity;

/**
 * 
 * @author ducbq
 */
@Entity
@Table(name = "aux_auth_account")
public class AuthenticateAccount extends RepoEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8299619161293678379L;

  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 64, message = "{LongString}")
  @Column(name = "sso_id")
  private String ssoId;

  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 64, message = "{LongString}")
  @Column(name = "password")
  private String password;

	@Size(max = 30, message = "{LongString}")
  @Column(name = "encoding_alg")
  private String encodingAlg;

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

	public String getEncodingAlg() {
		return encodingAlg;
	}

	public void setEncodingAlg(String encodingAlg) {
		this.encodingAlg = encodingAlg;
	}

}
