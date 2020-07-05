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

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.brilliant.auth.entity.AuthenticateAccount;
import net.brilliant.common.ListUtility;
import net.brilliant.entity.general.BusinessUnit;
import net.brilliant.entity.general.GeneralCatalogue;
import net.brilliant.framework.entity.RepoAuditable;
import net.brilliant.global.GlobalConstants;
import net.brilliant.model.GenderType;
import net.brilliant.model.PartnerType;

/**
 * A contact.
 * 
 * @author ducbq
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contact_core")
@EqualsAndHashCode(callSuper=false)
public class ContactCore extends RepoAuditable {
	private static final long serialVersionUID = -7270200825637800417L;

	@Column(name="code", length=GlobalConstants.SIZE_SERIAL, unique=true)
	private String code;

	@Column(name="saluation", length=5)
	private String saluation;

	@Column(name="first_name", length=50)
	private String firstName;

	@Column(name="last_name", length=150)
	private String lastName;

	@Column(name="display_name", length=150)
	private String displayName;

	@Column(name="title", length=50)
	private String title;

	@Builder.Default
  @OneToMany(
  		mappedBy="owner"
      , cascade = CascadeType.ALL
      , orphanRemoval = true
      , fetch = FetchType.EAGER
  )
	private List<ContactCommunication> contacPhones = ListUtility.createDataList();

  @Column(name="portal_name", length=50)
	private String portalName;

	@JsonIgnore
	@Column(name="portal_secret_key", length=50)
	private String portalSecretKey;

	@Builder.Default
	@Column(name = "portal_active")
	private java.lang.Boolean portalActive = false;

	@Column(name="email", /*nullable=false, unique = true, */length=120)
	private String email;

	@Column(name="email_others", length=120)
	private String emailOthers;

	@Builder.Default
	@Column(name = "email_opt_out")
	private java.lang.Boolean emailOptOut = false;

	@Builder.Default
	@Column(name = "email_invalid")
	private java.lang.Boolean emailInvalid = false;

	@ManyToOne
	@JoinColumn(name = "sms_opt_in_id")
	private GeneralCatalogue smsOptIn;

	@ManyToOne
	@JoinColumn(name = "lead_source_id")
	private GeneralCatalogue leadSource;

	@Column(name="fax", length=20)
	private String fax;

  @Column(name="birthdate")
	@DateTimeFormat(iso = ISO.DATE)
  private Date birthdate;

	@Column(name="birthplace", length=50)
	private String birthplace;

	@Column(name="gender")
  @Enumerated(EnumType.ORDINAL)
  private GenderType gender;

	@Builder.Default
	@Column(name="type")
  @Enumerated(EnumType.ORDINAL)
  private PartnerType type = PartnerType.Unknown;

	@Column(name="activation_key", length=20)
	@JsonIgnore
	private String activationKey;

	@Column(name="reset_key", length=20)
	@JsonIgnore
	private String resetKey;

	@Column(name="reset_date")
	private ZonedDateTime resetDate;

	@Lob
	@Column(name = "info", columnDefinition = "TEXT")
	@Type(type = "org.hibernate.type.TextType")
	private String info;

	@ManyToOne
	@JoinColumn(name = "referal_contact_id")
	private ContactCore referal;

	@ManyToOne
	@JoinColumn(name = "business_unit_id")
	private BusinessUnit businessUnit;

	@Builder.Default
	@Column(name = "sync_contact")
	private java.lang.Boolean syncContact = false;

	@Builder.Default
	@Column(name = "do_not_call")
	private java.lang.Boolean doNotCall = false;

	@Transient
	@Builder.Default
	private Set<ContactAddress> contactAddresses = ListUtility.newHashSet();

	@Builder.Default
	@Transient
	private Set<ContactTeam> contactTeams = ListUtility.newHashSet();
	
	@ManyToOne
	@JoinColumn(name = "owner_user_id")
	private AuthenticateAccount ownerAuthAccount;

  @Column(name="issue_date")
  private Date issueDate;
	
	@ManyToOne
  @JoinColumn(name="issue_user_id")
  private AuthenticateAccount issueAuthAccount;

}
