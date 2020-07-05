package net.brilliant.auth.entity;
/*
package net.paramount.auth.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;

import net.paramount.framework.entity.ObjectBase;

*//**
 * 
 * @author ducbui
 * 
 *//*

@Entity
@Table(name = "aux_user_profile")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM AuxUserProfile u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM AuxUserProfile u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByLogin", query = "SELECT u FROM AuxUserProfile u WHERE u.authAccount.ssoId = :login"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM AuxUserProfile u WHERE u.authAccount.password = :password"),
    @NamedQuery(name = "User.findByName", query = "SELECT u FROM AuxUserProfile u WHERE u.name = :name"),
    @NamedQuery(name = "User.findByUserType", query = "SELECT u FROM AuxUserProfile u WHERE u.userType = :userType"),
    @NamedQuery(name = "User.findByActive", query = "SELECT u FROM AuxUserProfile u WHERE u.active = :active")})
public class AuxUserProfile extends ObjectBase {
    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64, message = "{LongString}")
    @Column(name = "name")
    private String name;

    @Size(max = 64, message = "{LongString}")
    @Column(name = "user_type")
    private String userType;

    @Basic(optional = false)
    @NotNull
    @Column(name = "active")
    private Boolean active;

    @Lob
    @Column(name = "image")
    private byte[] image;

	@SuppressWarnings("deprecation")
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, mappedBy = "user")
	@Cascade({ 
		org.hibernate.annotations.CascadeType.SAVE_UPDATE, 
		org.hibernate.annotations.CascadeType.DELETE, 
		org.hibernate.annotations.CascadeType.MERGE,
		org.hibernate.annotations.CascadeType.PERSIST, 
		org.hibernate.annotations.CascadeType.DELETE_ORPHAN })
	private List<UserRole> roles = new ArrayList<UserRole>();

	@ManyToOne
	@JoinColumn(name = "auth_account_id")
	private AuthenticateAccount authAccount;

    public AuxUserProfile() {
    }

    public AuxUserProfile(String login, String password, String name, Boolean active) {
    	if (null == this.authAccount) {
    		this.authAccount = new AuthenticateAccount();
    	}

  		this.authAccount.setSsoId(login);
  		this.authAccount.setPassword(password);
        this.name = name;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
     public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }


    public List<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuxUserProfile)) {
            return false;
        }

        AuxUserProfile other = (AuxUserProfile) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User[ id=" + getId() + " ]";
    }

		public AuthenticateAccount getAuthAccount() {
			return authAccount;
		}

		public void setAuthAccount(AuthenticateAccount authAccount) {
			this.authAccount = authAccount;
		}
}
*/