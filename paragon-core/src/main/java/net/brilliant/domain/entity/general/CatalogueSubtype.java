/*
* Copyright 2018, Bui Quy Duc
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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.brilliant.framework.entity.RepoAuditable;
import net.brilliant.global.GlobalConstants;

/**
 * A catalog sub type equivalent to a category. One category consists one or more groups
 * 
 * @author bqduc
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "catalogue_subtype")
@EqualsAndHashCode(callSuper = true)
public class CatalogueSubtype extends RepoAuditable {
	private static final long serialVersionUID = -8694018855853561542L;

	@NotNull
	@Size(min = 3, max=GlobalConstants.SIZE_SERIAL)
	@Column(unique = true)
	private String code;

	@Size(max = GlobalConstants.SIZE_NAME)
	@Column(name="name")
	private String name;

	@Size(max = GlobalConstants.SIZE_NAME)
	@Column(name="translated_name")
	private String translatedName;

	@Lob
	@Column(name = "info", columnDefinition = "TEXT")
	@Type(type = "org.hibernate.type.TextType")
	private String info;

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private CatalogueSubtype parent;

	@ManyToOne
	@JoinColumn(name = "level_id")
	private Catalogue level;

	/**
	 * 10: sub type for local level of catalog
	 * 11: sub type for secondary level of catalog
	 * 12: sub type for main level of catalog
	 * 20: sub type for local level of group catalog
	 * 21: sub type for secondary level of group catalog
	 * 22: sub type for main level of group catalog
	 * 30: sub type for local level of goods category
	 * 31: sub type for secondary level of goods category
	 * 32: sub type for main level of goods category
	 * 40: sub type for local level of goods department
	 * 41: sub type for secondary level of goods department
	 * 42: sub type for main level of goods department
	 * ........
	 */
}
