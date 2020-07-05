/*
* Copyright 2017, Bui Quy Duc
* by the @authors tag. See the LICENCE in the distribution for a
* full listing of individual contributors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
* http://www.apache.org/licenses/LICENSE-2.0
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package net.brilliant.auth.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.brilliant.auth.model.AccessDecision;
import net.brilliant.common.ListUtility;
import net.brilliant.framework.entity.RepoAuditable;

/**
 * Module.
 * 
 * @author bqduc
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "aux_access_decision_policy")
public class AccessDecisionPolicy extends RepoAuditable {
	private static final long serialVersionUID = 5502198617024752752L;

	@Setter
	@Getter
	@NotNull
	@Column(name = "access_pattern", length=120)
	private String accessPattern;

	@Setter
	@Getter
	@Builder.Default
	@Column(name="access_decision")
  @Enumerated(EnumType.ORDINAL)
	private AccessDecision accessDecision = AccessDecision.ACCESS_ABSTAIN;

	/*@Setter
	@Getter
	@ManyToOne
	@JoinColumn(name = "authority_id")
	private Authority authority;*/

	@Setter
	@Getter
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private AccessDecisionPolicy parent;

	@Setter
	@Getter
	@Column(name = "info", columnDefinition="text")
	private String info;

	@Setter
	@Getter
	@Builder.Default
  @OneToMany(mappedBy="accessDecisionPolicy"
      , cascade = CascadeType.ALL
      , orphanRemoval = true
      , fetch = FetchType.EAGER)
  private List<AccessDecisionAuthority> accessDecisionAuthorities = ListUtility.createDataList();

	public AccessDecisionPolicy addAccessDecisionAuthority(Authority authority) {
		accessDecisionAuthorities.add(
				AccessDecisionAuthority.builder()
				.accessDecisionPolicy(this)
				.authority(authority)
				.build()
			);
		return this;
	}
}
