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

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.brilliant.auth.entity.UserAccountProfile;
import net.brilliant.common.ListUtility;
import net.brilliant.framework.entity.RepoAuditable;

/**
 * A contact.
 * 
 * @author Bui Quy Duc
 */
@Builder
@Data
@Entity
@Table(name = "contact_profile")
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ContactProfile extends RepoAuditable {
	private static final long serialVersionUID = -4848362258780874163L;

	@ManyToOne
	@JoinColumn(name = "contact_id")
	private ContactCore owner;

	@Builder.Default
  @OneToMany(
  		mappedBy="owner"
      , cascade = CascadeType.ALL
      , orphanRemoval = true
      //, fetch = FetchType.EAGER
  )
	private List<ContactAddress> addresses = ListUtility.createList();

	@Builder.Default
  @OneToMany(
  		mappedBy="owner"
      , cascade = CascadeType.ALL
      , orphanRemoval = true
      //, fetch = FetchType.EAGER
  )
	private List<ContactCommunication> communications = ListUtility.createList();

  @Builder.Default
  @OneToMany(
  		mappedBy="owner"
      , cascade = CascadeType.ALL
      , orphanRemoval = true
      //, fetch = FetchType.EAGER
  )
	private List<ContactHierarchy> hierarchies = ListUtility.createList();

  @Builder.Default
  @OneToMany(
  		mappedBy="owner"
      , cascade = CascadeType.ALL
      , orphanRemoval = true
      //, fetch = FetchType.EAGER
  )
	private List<ContactAssignment> assignments = ListUtility.createList();

	@ManyToOne
	@JoinColumn(name = "assistant_contact_id")
	private ContactCore assistant;

	@ManyToOne
	@JoinColumn(name = "introducer_contact_id")
	private ContactCore introducer;

	@ManyToOne
	@JoinColumn(name = "owned_user_id")
	private UserAccountProfile ownedUser;

  @Column(name="issued_date")
  private Date issuedDate;

	@ManyToOne
  @JoinColumn(name="issued_user_id")
  private UserAccountProfile issuedUser;

}
