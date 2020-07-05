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

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import net.brilliant.framework.entity.RepoAuditable;


@Entity
@Table(name="PORTFOLIO")
public class Portfolio extends RepoAuditable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="CODE", length=20, nullable=false, unique=true ) 
    @NotNull
    @Size(max=20, min=1)
	private String code;
	
	@Column(name="NAME", length=50 )
	@Size(max=50)
	private String name;
	
	@Column( name="INFO" )
	private String info;
	
	@Column(name="BLOCKED")
	private Boolean blocked;
	
	@ManyToOne
	@JoinColumn(name="BANK_ID")
	private Bank bank;
	
	@ManyToOne
	@JoinColumn(name="BANK_BRANCH_ID")
	private BankBranch bankBranch;
	
	@ManyToOne
	@JoinColumn(name="BANK_ACCOUNT_ID")
	private BankAccount bankAccount;

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getInfo() {
		return info;
	}

	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}

	public Boolean getBlocked() {
		return blocked;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankBranch(BankBranch bankBranch) {
		this.bankBranch = bankBranch;
	}

	public BankBranch getBankBranch() {
		return bankBranch;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Bank getBank() {
		return bank;
	}
	
	@Override
    public String toString() {
        return "Portfolio[id=" + getId() + "]";
    }
	
}
