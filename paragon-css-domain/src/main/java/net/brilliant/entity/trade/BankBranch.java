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
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import net.brilliant.embeddable.Address;
import net.brilliant.entity.contact.ContactPerson;
import net.brilliant.entity.general.Organization;
import net.brilliant.framework.entity.RepoAuditable;

@Entity
@Table(name="BANK_BRANCH")
public class BankBranch extends RepoAuditable {

	private static final long serialVersionUID = 1L;

	@Column(name = "CODE", length = 20, unique = true, nullable = false)
	@Size(max = 20, min = 1)
	@NotNull
	private String code;

	@Column(name = "NAME", length = 50)
	@Size(max = 50)
	private String name;

	@Column(name = "INFO")
	private String info;

	@Column(name = "WORK_BEGIN")
	@Temporal(TemporalType.DATE)
	private Date workBegin;

	@Column(name = "WORK_END")
	@Temporal(TemporalType.DATE)
	private Date workEnd;

	@ManyToOne
	@JoinColumn(name = "BANK_ID")
	private Bank bank;

	@Column(name = "EFT_CODE", length = 20)
	@Size(max = 20)
	private String eftCode;

	@Column(name = "CHEQUE_CODE", length = 20)
	@Size(max = 20)
	private String chequeCode;

	@Embedded
	@Valid
	private Address address = new Address();

	@ManyToOne
	@JoinColumn(name = "ORGANIZATION_ID")
	private Organization organization;

	@Embedded
	private ContactPerson contactPerson = new ContactPerson();
	/* s
    @OneToMany(mappedBy = "bankBranch", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<BankAccount> items = new ArrayList<BankAccount>();
	 */
	
	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

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

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Date getWorkBegin() {
		return workBegin;
	}

	public void setWorkBegin(Date workBegin) {
		this.workBegin = workBegin;
	}

	public Date getWorkEnd() {
		return workEnd;
	}

	public void setWorkEnd(Date workEnd) {
		this.workEnd = workEnd;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public String getEftCode() {
		return eftCode;
	}

	public void setEftCode(String eftCode) {
		this.eftCode = eftCode;
	}

	public String getChequeCode() {
		return chequeCode;
	}

	public void setChequeCode(String chequeCode) {
		this.chequeCode = chequeCode;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ContactPerson getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(ContactPerson contactPerson) {
		this.contactPerson = contactPerson;
	}

	@Override
    public String toString() {
        return "BankBranch[id=" + getId() + "]";
    }
/*
	public List<BankAccount> getItems() {
		return items;
	}

	public void setItems(List<BankAccount> items) {
		this.items = items;
	}
*/
}
