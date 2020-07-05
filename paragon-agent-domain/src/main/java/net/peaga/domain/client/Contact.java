package net.peaga.domain.client;

import java.math.BigDecimal;
import java.util.Date;

import net.peaga.domain.base.Repository;
import net.peaga.domain.enums.ContactType;
import net.peaga.domain.enums.EducationType;
import net.peaga.domain.enums.GenderType;
import net.peaga.domain.enums.MaritalStatus;

/**
 * Entity class Contact
 * 
 * @author DucBQ
 */
public class Contact extends Repository  {
	private static final long serialVersionUID = 1L;
	private String code;

	private String firstName;

	private String lastName;

	private ContactType contactType = ContactType.Unknown;

	private ContactCategory category;

	private String representative;

	private String company;

	private String title;

	private String taxNumber;

	private String taxOffice;

	private String ssn; 

	private String ssnOffice; 

	private BigDecimal debitLimit = BigDecimal.ZERO;

	private BigDecimal riskLimit = BigDecimal.ZERO;

	private Date startWorkingDate;

	private Date endWorkingDate;

	private Date birthdate;

	private GenderType gender;

	private EducationType education;

	private String passportNo;

	private MaritalStatus maritalStatus;

	/*@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	@OrderBy("defaultAddress DESC,activeAddress DESC")
	private List<ContactAddress> addressList = new ArrayList<ContactAddress>();

	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	@OrderBy("defaultPhone DESC,activePhone DESC")
	private List<ContactPhone> phoneList = new ArrayList<ContactPhone>();

	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	@OrderBy("defaultNetwork DESC,activeNetwork DESC")
	private List<ContactNetwork> networkList = new ArrayList<ContactNetwork>();*/

	private String info;

	public Contact(){
	}

	public Contact(ContactType contactType, String firstName, String lastName, String info){
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactType = contactType;
		this.info = info;
	}

	public Contact(String code, String firstName, String lastName, ContactType contactType, String info){
		this.code = code;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactType = contactType;
		this.info = info;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.id != null ? this.id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Contact)) {
			return false;
		}
		Contact other = (Contact) object;
		if (this.id != other.id && (this.id == null || !this.id.equals(other.id)))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contact[id=" + id + ", code=" + getCode()+ "]";
	}

	/*public ContactAddress getDefaultAddress() {
		for (ContactAddress item : addressList) {
			if (item.getDefaultAddress())
				return item;
		}
		return null;
	}

	public ContactPhone getDefaultPhone() {
		for (ContactPhone item : phoneList) {
			if (item.getDefaultPhone())
				return item;
		}
		return null;
	}

	public List<ContactNetwork> getNetworkList() {
		return networkList;
	}

	public void setNetworkList(List<ContactNetwork> networkList) {
		this.networkList = networkList;
	}

	public List<ContactPhone> getPhoneList() {
		return phoneList;
	}

	public void setPhoneList(List<ContactPhone> phoneList) {
		this.phoneList = phoneList;
	}*/

	public EducationType getEducation() {
		return education;
	}

	public void setEducation(EducationType education) {
		this.education = education;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public ContactCategory getCategory() {
		return category;
	}

	public void setCategory(ContactCategory category) {
		this.category = category;
	}

	public String getRepresentative() {
		return representative;
	}

	public void setRepresentative(String representative) {
		this.representative = representative;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	public String getTaxOffice() {
		return taxOffice;
	}

	public void setTaxOffice(String taxOffice) {
		this.taxOffice = taxOffice;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	/*public String getCaption() {
		String caption = "";
		if (!CommonUtility.isEmpty(this.company)){
			caption = getCompany()+":";
		}
		caption += "[" + getCode() + "] " + getFullName();
		return caption;
	}*/

	public BigDecimal getDebitLimit() {
		return debitLimit;
	}

	public void setDebitLimit(BigDecimal debitLimit) {
		this.debitLimit = debitLimit;
	}

	public BigDecimal getRiskLimit() {
		return riskLimit;
	}

	public void setRiskLimit(BigDecimal riskLimit) {
		this.riskLimit = riskLimit;
	}

	public Date getStartWorkingDate() {
		return startWorkingDate;
	}

	public void setStartWorkingDate(Date startWorkingDate) {
		this.startWorkingDate = startWorkingDate;
	}

	public Date getEndWorkingDate() {
		return endWorkingDate;
	}

	public void setEndWorkingDate(Date endWorkingDate) {
		this.endWorkingDate = endWorkingDate;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public GenderType getGender() {
		return gender;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}

	/*@Transient
	public String getFullName() {
		return new StringBuilder(this.firstName).append(" ").append(this.lastName).toString();
	}*/

	/**
	 * @return the passportNo
	 */
	public String getPassportNo() {
		return passportNo;
	}

	/**
	 * @param passportNo
	 *          the passportNo to set
	 */
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	/**
	 * @return the maritalStatus
	 */
	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	/**
	 * @param maritalStatus
	 *          the maritalStatus to set
	 */
	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	/*public List<ContactAddress> getAddressList() {
		return addressList;
	}

	public List<ContactAddress> getActiveAddressList() {
		List<ContactAddress> actAddrList = new ArrayList<ContactAddress>();
		for (ContactAddress ca : addressList) {
			if (ca.getActiveAddress())
				actAddrList.add(ca);
		}
		return actAddrList;
	}

	public void setAddressList(List<ContactAddress> addressList) {
		this.addressList = addressList;
	}*/

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public ContactType getContactType() {
		return contactType;
	}

	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}

	public String getSsnOffice() {
		return ssnOffice;
	}

	public void setSsnOffice(String ssnOffice) {
		this.ssnOffice = ssnOffice;
	}

}