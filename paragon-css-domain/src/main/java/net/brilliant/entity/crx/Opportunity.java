package net.brilliant.entity.crx;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.brilliant.auth.entity.AuthenticateAccount;
import net.brilliant.entity.contact.CTAContact;
import net.brilliant.entity.contact.Team;
import net.brilliant.entity.general.Currency;
import net.brilliant.framework.entity.RepoAuditable;

/**
 * An Opportunity or CRX.
 */
@Builder
@NoArgsConstructor 
@AllArgsConstructor
@Entity
@Table(name = "opportunity")
@EqualsAndHashCode(callSuper=false)
public class Opportunity extends RepoAuditable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2085232964319407674L;

	@Column(name = "name", nullable = false, unique=true, length=200)
	private String name;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "currency_id", insertable=false, updatable=false)
	private Currency currency;

	@Digits(integer=12, fraction=2)
	@Column(name = "amount")
	private BigDecimal amount;

	@ManyToOne
	@JoinColumn(name = "account_id")
	private CustomerAccount account;

	@Column(name="type_id")
  @Enumerated(EnumType.ORDINAL)
	private CRXGeneralType type;

	@Column(name="lead_source_id")
  @Enumerated(EnumType.ORDINAL)
	private CRXLeadSource leadSource;
	
	@Column(name="sales_stage_id")
  @Enumerated(EnumType.ORDINAL)
	private CRXGeneralStage salesStage;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "currency_id")
	private AuthenticateAccount assignedTo;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "team_id")
	private Team team;

  @Column(name="closed_date")
	@DateTimeFormat(iso = ISO.DATE)
  private Date closedDate;

	@Column(name = "next_step", length=100)
	private String nextStep;

	@Digits(integer=12, fraction=2)
	@Column(name = "probability")
	private Float probability;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "campaign_id")
	private Campaign campaign;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "b2c_contact_id")
	private CTAContact b2cContact;

	@Column(name = "info", columnDefinition="TEXT")
	private String info;

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Opportunity parent;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Opportunity getParent() {
		return parent;
	}

	public void setParent(Opportunity parent) {
		this.parent = parent;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public CustomerAccount getAccount() {
		return account;
	}

	public void setAccount(CustomerAccount account) {
		this.account = account;
	}

	public CRXGeneralType getType() {
		return type;
	}

	public void setType(CRXGeneralType type) {
		this.type = type;
	}

	public CRXLeadSource getLeadSource() {
		return leadSource;
	}

	public void setLeadSource(CRXLeadSource leadSource) {
		this.leadSource = leadSource;
	}

	public CRXGeneralStage getSalesStage() {
		return salesStage;
	}

	public void setSalesStage(CRXGeneralStage salesStage) {
		this.salesStage = salesStage;
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

	public Date getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}

	public String getNextStep() {
		return nextStep;
	}

	public void setNextStep(String nextStep) {
		this.nextStep = nextStep;
	}

	public Float getProbability() {
		return probability;
	}

	public void setProbability(Float probability) {
		this.probability = probability;
	}

	public Campaign getCampaign() {
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	public CTAContact getB2cContact() {
		return b2cContact;
	}

	public void setB2cContact(CTAContact b2cContact) {
		this.b2cContact = b2cContact;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
