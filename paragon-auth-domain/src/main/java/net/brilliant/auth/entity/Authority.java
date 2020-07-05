
package net.brilliant.auth.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.brilliant.domain.entity.general.Catalogue;
import net.brilliant.framework.entity.RepoEntity;

/**
 * 
 * @author ducbq
 * 
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "aux_authority")
public class Authority extends RepoEntity implements GrantedAuthority {
	private static final long serialVersionUID = 1L;

	@Setter @Getter
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 64, message = "{LongString}")
	@Column(name = "name", unique=true)
	private String name;

	@Setter
	@Getter
	@NotNull
	@Size(min = 1, max = 150)
	@Column(name = "display_name")
	private String displayName;

	@Setter
	@Getter
	@Builder.Default
	@Basic(optional = false)
	@NotNull
	@Column(name = "active")
	private Boolean active = Boolean.FALSE;

	@Setter
	@Getter
	@Column(name = "info")
	private String info;

	@Setter
	@Getter
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Authority parent;

	/*@Setter
	@Getter
	@Column(name = "category_id")
	private Long categoryId;*/
	
	@Setter
	@Getter
	@Builder.Default
	@Column(name = "is_administration")
	private Boolean isAdministration = Boolean.FALSE;

	@Setter
	@Getter
	@ManyToOne
	@JoinColumn(name = "category_catalogue_id")
	private Catalogue category;

	@Override
	public String toString() {
		return "Authority [ id=" + getId() + " ]";
	}

	@Override
	public String getAuthority() {
		return this.name;
	}
}