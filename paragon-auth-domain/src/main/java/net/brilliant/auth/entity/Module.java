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

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
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
@Table(name = "aux_module")
public class Module extends RepoAuditable {
	private static final long serialVersionUID = 5474725952032953164L;

	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "name", unique=true)
	private String name;

	@Column(name = "alias", length=15)
	private String alias;

	@Column(name = "author", length=80)
	private String author;
	
	@Column(name = "enable")
	private java.lang.Boolean enable;
	
	@Column(name = "info", columnDefinition="text")
	private String info;

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Module parent;

	@Column(name = "integrate_date")
	private Date integrateDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Module getParent() {
		return parent;
	}

	public void setParent(Module parent) {
		this.parent = parent;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public java.lang.Boolean getEnable() {
		return enable;
	}

	public void setEnable(java.lang.Boolean enable) {
		this.enable = enable;
	}
	
}
