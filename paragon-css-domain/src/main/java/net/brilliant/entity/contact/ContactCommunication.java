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
package net.brilliant.entity.contact;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.brilliant.embeddable.Phone;
import net.brilliant.framework.entity.RepoAuditable;

/**
 * A contact.
 * 
 * @author Bui Quy Duc
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contact_communication")
@EqualsAndHashCode(callSuper=false)
public class ContactCommunication extends RepoAuditable {
	private static final long serialVersionUID = -7270200825637800417L;

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private ContactProfile owner;

	@Column(name="type", length=30) //Home, Work, Mobile, ...
	private String type;

  @Embedded
  @AttributeOverrides({
		@AttributeOverride(name = "countryCode", column = @Column(name = "country_code")),
		@AttributeOverride(name = "areaCode", column = @Column(name = "area_code")),
		@AttributeOverride(name = "number", column = @Column(name = "number")),
		@AttributeOverride(name = "extension", column = @Column(name = "extension"))
  })
  private Phone phone; 

	@Column(name="fax", length=20)
	private String fax;

	@Column(name="email", length=150)
	private String email;
}
