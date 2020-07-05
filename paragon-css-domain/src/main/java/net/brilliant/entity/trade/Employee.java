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

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.Valid;

import net.brilliant.embeddable.Address;
import net.brilliant.embeddable.Phone;
import net.brilliant.entity.general.Department;
import net.brilliant.framework.entity.RepoEntity;

@Entity
@Table(name="EMPLOYEE")
public class Employee extends RepoEntity {
	
	private static final long serialVersionUID = 1L;

	@Column(name="PERSONNEL_NO", nullable=false, unique=true, length=20)
	private String personnelNo; //kurum sicilno
	
	@Column(name="SSN", length=11)
	private String ssn;  //tckimlikno
	
	@Column(name="PASSPORT_NO", length=11)
	private String passportNo;
	
	@Column(name="SSK_NO", length=20)
	private String sskNo;
	
	@Column(name="FIRST_NAME", length=30)
	private String firstName;
	
	@Column(name="LAST_NAME", length=20)
	private String lastName;
	
	@Embedded
	@Valid
	private Phone phone = new Phone();
	
	@Embedded
	@Valid
    private Address address=new Address();
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="ISACTIVE")
	private Boolean active = Boolean.TRUE;
	
	@ManyToOne
	@JoinColumn(name="DEPARTMENT_ID")
	private Department department;
	
	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

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

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getSskNo() {
		return sskNo;
	}

	public void setSskNo(String sskNo) {
		this.sskNo = sskNo;
	}

	public String getPersonnelNo() {
		return personnelNo;
	}

	public void setPersonnelNo(String personnelNo) {
		this.personnelNo = personnelNo;
	}

	@Override
    public String toString() {
        return "Employee[id=" + getId() + "]";
    }
	
	/**
	 * Employee popuptan gelen degeri kullanan converter icin gerekli
	 * @see EmployeeCaptionConverter
	 */
	@Transient
	public String getCaption(){
	    return "[" + getPersonnelNo() + "] " + getFirstName() + " " + getLastName();
	}
	
}
