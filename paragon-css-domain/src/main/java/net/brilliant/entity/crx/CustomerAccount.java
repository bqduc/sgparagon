package net.brilliant.entity.crx;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.brilliant.auth.entity.AuthenticateAccount;
import net.brilliant.embeddable.Address;
import net.brilliant.embeddable.Phone;
import net.brilliant.entity.contact.Team;
import net.brilliant.framework.entity.RepoAuditable;
import net.brilliant.global.GlobalConstants;

/**
 * An account or CRX.
 */
@Builder
@NoArgsConstructor 
@AllArgsConstructor
@Entity
@Table(name = "customer_account")
@EqualsAndHashCode(callSuper=false)
public class CustomerAccount extends RepoAuditable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2519286162124918877L;

	@Column(name="code", length=GlobalConstants.SIZE_SERIAL, unique=true)
	private String code;

	@Column(name = "name", nullable = false, length=200)
	private String name;

  @Embedded
  @AttributeOverrides({
		@AttributeOverride(name = "countryCode", column = @Column(name = "PHONE_COUNTRYCODE")),
		@AttributeOverride(name = "areaCode", column = @Column(name = "PHONE_AREACODE")),
		@AttributeOverride(name = "number", column = @Column(name = "PHONE_NUMBER")),
		@AttributeOverride(name = "extention", column = @Column(name = "PHONE_EXTENTION"))
  })
  private Phone phone; // office - working phone

  @Embedded
  @AttributeOverrides({
		@AttributeOverride(name = "countryCode", column = @Column(name = "HOME_PHONE_COUNTRYCODE")),
		@AttributeOverride(name = "areaCode", column = @Column(name = "HOME_PHONE_AREACODE")),
		@AttributeOverride(name = "number", column = @Column(name = "HOME_PHONE_NUMBER")),
		@AttributeOverride(name = "extention", column = @Column(name = "HOME_PHONE_EXTENTION"))
  })
  private Phone homePhone;

  @Embedded
  @AttributeOverrides({
		@AttributeOverride(name = "countryCode", column = @Column(name = "MOBILE_PHONE_COUNTRYCODE")),
		@AttributeOverride(name = "areaCode", column = @Column(name = "MOBILE_PHONE_AREACODE")),
		@AttributeOverride(name = "number", column = @Column(name = "MOBILE_PHONE_NUMBER")),
		@AttributeOverride(name = "extention", column = @Column(name = "MOBILE_PHONE_EXTENTION"))
  })
  private Phone mobilePhone;

	@Column(name = "website", length=100)
	private String website;
	
	@Column(name = "fax", length=50)
	private String fax;
	
	@Column(name = "ticker_symbol", length=15)
	private String tickerSymbol;
	
	@ManyToOne
	@JoinColumn(name = "member_of_id")
	private CustomerAccount memberOf;

	@Column(name = "email", length=150)
	private String email;

	@Column(name = "email_others", length=150)
	private String emailOthers;

	@Column(name = "employees", length=15)
	private String employees;

	@Column(name = "ownership", length=150)
	private String ownership;

	@Column(name = "rating", length=50)
	private String rating;

	@ManyToOne(targetEntity=Industry.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "industry_id")
	private Industry industry;

	@Column(name = "sic_code", length=15)
	private String sicCode;//The Standard Industrial Classification code is meta-data that helps you organize accounts.
	
	@Column(name="account_type_id")
  @Enumerated(EnumType.ORDINAL)
	private CRXGeneralType accountType;

	@Column(name = "annual_revenue", length=25)
	private String annualRevenue;

	@Embedded
  @AttributeOverrides({
    @AttributeOverride(name="address", column=@Column(name="shipping_address")),
    @AttributeOverride(name="city", column=@Column(name="shipping_city")),
    @AttributeOverride(name="state", column=@Column(name="shipping_state")),
    @AttributeOverride(name="postalCode", column=@Column(name="shipping_postal_code")),
    @AttributeOverride(name="country", column=@Column(name="shipping_country"))
  })
  private Address shippingAddress;

	@Embedded
  @AttributeOverrides({
    @AttributeOverride(name="address", column=@Column(name="billing_address")),
    @AttributeOverride(name="city", column=@Column(name="billing_city")),
    @AttributeOverride(name="state", column=@Column(name="billing_state")),
    @AttributeOverride(name="postalCode", column=@Column(name="billing_postal_code")),
    @AttributeOverride(name="country", column=@Column(name="billing_country"))
  })
  private Address billingAddress;

	@ManyToOne(targetEntity=AuthenticateAccount.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "currency_id")
	private AuthenticateAccount assignedTo;

	@ManyToOne(targetEntity=Team.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "team_id")
	private Team team;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AuthenticateAccount getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(AuthenticateAccount assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getTickerSymbol() {
		return tickerSymbol;
	}

	public void setTickerSymbol(String tickerSymbol) {
		this.tickerSymbol = tickerSymbol;
	}

	public CustomerAccount getMemberOf() {
		return memberOf;
	}

	public void setMemberOf(CustomerAccount memberOf) {
		this.memberOf = memberOf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailOthers() {
		return emailOthers;
	}

	public void setEmailOthers(String emailOthers) {
		this.emailOthers = emailOthers;
	}

	public String getEmployees() {
		return employees;
	}

	public void setEmployees(String employees) {
		this.employees = employees;
	}

	public String getOwnership() {
		return ownership;
	}

	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Industry getIndustry() {
		return industry;
	}

	public void setIndustry(Industry industry) {
		this.industry = industry;
	}

	public String getSicCode() {
		return sicCode;
	}

	public void setSicCode(String sicCode) {
		this.sicCode = sicCode;
	}

	public CRXGeneralType getAccountType() {
		return accountType;
	}

	public void setAccountType(CRXGeneralType accountType) {
		this.accountType = accountType;
	}

	public String getAnnualRevenue() {
		return annualRevenue;
	}

	public void setAnnualRevenue(String annualRevenue) {
		this.annualRevenue = annualRevenue;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public Phone getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(Phone homePhone) {
		this.homePhone = homePhone;
	}

	public Phone getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(Phone mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
}
