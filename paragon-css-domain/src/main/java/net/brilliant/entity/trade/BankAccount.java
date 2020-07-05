/*
 * Copyleft 2007-2011 Ozgur Yazilim A.S.
 *
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 * http://www.gnu.org/licenses/lgpl.html
 *
 * www.tekir.com.tr
 * www.ozguryazilim.com.tr
 *
 */

package net.brilliant.entity.trade;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import net.brilliant.framework.entity.RepoAuditable;

@Entity
@Table(name="BANK_ACCOUNTS")
public class BankAccount extends RepoAuditable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="BANK_BRANCH_ID")
	private BankBranch bankBranch;

    @Column(name="NAME", length=50)
    @Size(max=50)
	private String name;

    @Column(name="ACCOUNT_DEPOSIT_TYPE")
    @Enumerated(EnumType.ORDINAL)
    private AccountDepositType accountDepositType = AccountDepositType.TimeDeposit;

    @Column(name="ACCOUNT_NO", length=25)
    @Size(max=25)
	private String accountNo;
	
    @Column(name="IBAN", length=50)
    @Size(max=50)
	private String iban;
	
	@Column(name="CCY", length=3)
	@Size(max=3)
    private String currency;
	
    @Column(name="OPEN_DATE")
    @Temporal(TemporalType.DATE)
	private Date openDate;
	
    @Column(name="CLOSE_DATE")
    @Temporal(TemporalType.DATE)
	private Date closeDate;
	
	/*Ek kodlama alnları?! Mesela şube ya da servis bağantısı için ne yapmalı...*/
    @Column(name="EXCODE1")
	private String excode1;
	
    @Column(name="EXCODE2")
	private String excode2;
	
	/**
	 *  Interest rate
	 */
    @Column(name="RATE", precision=5, scale=2)
	private Float rate = 0f;
	
    /**
     * Holds period of time for time deposit.
     */
    @Column(name="TERM")
	private Integer term = 0;
	
    @Column(name="ACCOUNT_OWNER_TYPE")
    @Enumerated(EnumType.ORDINAL)
    private AccountOwnerType accountOwnerType = AccountOwnerType.Mine;
    
    @Column(name="WEIGHT")
    private Integer weight = 10;
    
	public BankBranch getBankBranch() {
		return bankBranch;
	}
	
	public void setBankBranch(BankBranch bankBranch) {
		this.bankBranch = bankBranch;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public String getIban() {
		return iban;
	}
	
	public void setIban(String iban) {
		this.iban = iban;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public Date getOpenDate() {
		return openDate;
	}
	
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	
	public Date getCloseDate() {
		return closeDate;
	}
	
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	
	public String getExcode1() {
		return excode1;
	}
	
	public void setExcode1(String excode1) {
		this.excode1 = excode1;
	}
	
	public String getExcode2() {
		return excode2;
	}
	
	public void setExcode2(String excode2) {
		this.excode2 = excode2;
	}
	
	public Float getRate() {
		return rate;
	}
	
	public void setRate(Float rate) {
		this.rate = rate;
	}
		  
	public Integer getTerm() {
		return term;
	}

	public void setTerm(Integer term) {
		this.term = term;
	}

	public AccountDepositType getAccountDepositType() {
		return accountDepositType;
	}

	public void setAccountDepositType(AccountDepositType accountDepositType) {
		this.accountDepositType = accountDepositType;
	}

	
	@Override
    public String toString() {
        return "BankAccount[id=" + getId() + "]";
    }

	public AccountOwnerType getAccountOwnerType() {
		return accountOwnerType;
	}

	public void setAccountOwnerType(AccountOwnerType accountOwnerType) {
		this.accountOwnerType = accountOwnerType;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

}
