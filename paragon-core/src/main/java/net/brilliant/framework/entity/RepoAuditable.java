package net.brilliant.framework.entity;

import java.beans.Transient;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
public abstract class RepoAuditable extends Auditable<Long> {
	private static final long serialVersionUID = -8994521728871616441L;

	@Setter @Getter
	@Column(name = "visible")
	private Boolean visible = Boolean.FALSE;

	@Transient
	public boolean isSelected(Long id){
		if (null != id){
			return this.getId().equals(id);
		}
		return false;
	}

	public static RepoAuditable buildObject(List<String> data) {
		return null;
	}
}