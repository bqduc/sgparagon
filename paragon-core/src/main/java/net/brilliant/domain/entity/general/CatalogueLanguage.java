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
package net.brilliant.domain.entity.general;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.brilliant.framework.entity.RepoAuditable;

/**
 * A localized item.
 * 
 * @author bqduc
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "catalogue_language")
@EqualsAndHashCode(callSuper = true)
public class CatalogueLanguage extends RepoAuditable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3048307487182721300L;

	@ManyToOne
	@JoinColumn(name = "catalogue_id")
	private CatalogueItem catalogue;

	@ManyToOne
	@JoinColumn(name = "language_id")
	private Language language;

	@Size(max = 300)
	@Column(name="value")
	private String value;

	public CatalogueItem getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(CatalogueItem catalogue) {
		this.catalogue = catalogue;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
