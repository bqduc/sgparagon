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
package net.brilliant.entity.general;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.brilliant.framework.entity.RepoAuditable;
import net.brilliant.global.GlobalConstants;

/**
 * An item.
 * 
 * @author bqduc
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "general_item")
@EqualsAndHashCode(callSuper = true)
public class GeneralCatalogue extends RepoAuditable {
	private static final long serialVersionUID = -3725780457128265336L;

	@NotNull
	@Size(min = 3, max = GlobalConstants.SIZE_CODE)
	@Column(unique = true)
	private String code;

	@NotNull
	@Size(min = 3, max = GlobalConstants.SIZE_NAME)
	@Column(unique = true)
	private String name;

	@Size(max = GlobalConstants.SIZE_NAME_TINY)
	@Column(name="subtype")
	private String subtype;

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private GeneralCatalogue parent;

	@Lob
	@Column(name="info", columnDefinition="TEXT")
	private String info;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public GeneralCatalogue getParent() {
		return parent;
	}

	public void setParent(GeneralCatalogue parent) {
		this.parent = parent;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
