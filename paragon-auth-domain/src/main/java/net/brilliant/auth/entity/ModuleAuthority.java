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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import net.brilliant.framework.entity.RepoAuditable;
import net.brilliant.global.GlobalConstants;

/**
 * Module.
 * 
 * @author bqduc
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "aux_module_authority")
public class ModuleAuthority extends RepoAuditable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7537984682424729342L;

	@ManyToOne
	@JoinColumn(name = "module_id")
	private Module module;

	@ManyToOne
	@JoinColumn(name = "authority_id")
	private Authority authority;

	@Column(name = "manager_code", length=GlobalConstants.SIZE_CODE)
	private String managerCode;

	@Column(name = "approver_code", length=GlobalConstants.SIZE_CODE)
	private String approverCode;
	
	@Column(name = "enabled")
	private java.lang.Boolean enabled;
	
	@Column(name = "affective_date")
	private Date affectiveDate;

	@Column(name = "granted_date")
	private Date grantedDate;

	@Column(name = "info", columnDefinition="text")
	private String info;

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public String getManagerCode() {
		return managerCode;
	}

	public void setManagerCode(String managerCode) {
		this.managerCode = managerCode;
	}

	public String getApproverCode() {
		return approverCode;
	}

	public void setApproverCode(String approverCode) {
		this.approverCode = approverCode;
	}

	public java.lang.Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(java.lang.Boolean enabled) {
		this.enabled = enabled;
	}

	public Date getAffectiveDate() {
		return affectiveDate;
	}

	public void setAffectiveDate(Date affectiveDate) {
		this.affectiveDate = affectiveDate;
	}

	public Date getGrantedDate() {
		return grantedDate;
	}

	public void setGrantedDate(Date grantedDate) {
		this.grantedDate = grantedDate;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

}
