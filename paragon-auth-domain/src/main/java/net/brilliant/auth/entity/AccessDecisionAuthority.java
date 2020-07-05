package net.brilliant.auth.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.brilliant.framework.entity.RepoEntity;

/**
 * 
 * @author ducbq
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "aux_access_decision_authority")
public class AccessDecisionAuthority extends RepoEntity {
	private static final long serialVersionUID = -8568792387287150298L;

	@Setter
	@Getter
	@ManyToOne
	@JoinColumn(name = "access_decision_policy_id")
	private AccessDecisionPolicy accessDecisionPolicy;

	@Setter
	@Getter
	@ManyToOne
	@JoinColumn(name = "authority_id")
	private Authority authority;

}
