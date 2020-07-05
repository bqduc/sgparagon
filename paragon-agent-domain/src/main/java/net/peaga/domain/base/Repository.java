/**
 * 
 */
package net.peaga.domain.base;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.builder.EqualsBuilder;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ducbq
 *
 */
public class Repository implements IRepository{
	private static final long serialVersionUID = -1040917988695248005L;
	//private static final Logger logger = LogManager.getLogger(Repository.class);

	@Setter
	@Getter
	protected Long id;

	private Long clientId;

	private Boolean active = Boolean.TRUE;

	private Boolean system = Boolean.TRUE; //False indicate removed by the application

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Boolean getSystem() {
		return system;
	}

	public void setSystem(Boolean system) {
		this.system = system;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.getId() != null ? this.getId().hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		/*if (!(object instanceof Repository)) {
			return false;
		}
		Repository other = (Repository) object;
		if (this.getId() != other.getId() && (this.getId() == null || !this.getId().equals(other.getId())))
			return false;

		return true;*/
		return EqualsBuilder.reflectionEquals(this, object);
	}

	@Override
	public String toString() {
		StringBuilder objectSpec = new StringBuilder();
		String objectCode = null;
		try {
			objectCode = BeanUtils.getProperty(this, "code");
		} catch (Exception e) {
			objectCode = "Unknown";
			//logger.error("Object " + this + " does not have code property. ");
		}
		return objectSpec
		.append(this.getClass().getSimpleName())
		.append("[")
		.append("id: ").append(this.getId())
		.append(", ")
		.append("code: ").append(objectCode)
		.append("]")
		.toString();
	}

	@Override
	public RepositoryId getRepositoryId() {
		return new RepositoryId(this.id);
	}

	@Override
	public void setRepositoryId(RepositoryId repositoryId) {
		this.id = repositoryId.getObjectId();
	}
}
