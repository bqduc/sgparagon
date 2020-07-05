package net.brilliant.framework.entity;

import java.beans.Transient;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
public abstract class RepoEntity implements Entity {
	private static final long serialVersionUID = 5174493359368640877L;

  @Setter @Getter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private java.lang.Long id;

  @Setter @Getter
	@Column(name = "system")
	private Boolean system = Boolean.TRUE;

	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}*/

  /**
   * Determines whether another object is equal to this business object.  The result is 
   * <code>true</code> if and only if the argument is not null and is a business object that 
   * has the same id field values as this object.
   * @param object the reference object with which to compare
   * @return <code>true</code> if this object is the same as the argument;
   * <code>false</code> otherwise.
   */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		RepoEntity other = (RepoEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id)) {
			return false;
		}

		return true;
	}

	public int compareTo(Object obj) {
		if (obj.hashCode() > hashCode())
			return 1;
		else if (obj.hashCode() < hashCode())
			return -1;

		return 0;
	}

	public String toString() {
		return new StringBuilder("Id: ").append(this.id).toString();
	}

	@Transient
	public boolean isSelected(Long id) {
		if (null != id) {
			return this.getId().equals(id);
		}
		return false;
	}
}