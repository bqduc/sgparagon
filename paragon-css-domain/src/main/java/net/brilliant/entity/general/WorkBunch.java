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

package net.brilliant.entity.general;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import net.brilliant.entity.contact.CTAContact;
import net.brilliant.framework.entity.RepoEntity;

/**
 * İş takibi bilgilerini tutan model sınıfımızdır.
 * 
 * @author sinan.yumak
 *
 */
@Entity
@Table(name="WORK_BUNCH")
public class WorkBunch extends RepoEntity {

	private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name="CONTACT_ID", foreignKey = @ForeignKey(name = "FK_WORKBUNCH_CONTACTID"))
    private CTAContact contact;
    
    @Column(name="INFO")
    private String info;

    @Column(name="CODE",length=20,unique=true,nullable=false)
    @Size(max=20, min=1)
    private String code;

    @Column(name="NAME",length=40)
    private String name;

	@Enumerated(EnumType.ORDINAL)
    @Column(name="WORKBUNCH_STATUS")
    private WorkBunchStatus workBunchStatus;
    
	@Temporal(TemporalType.DATE)
    @Column(name="BEGIN_DATE")
    private Date beginDate;

	@Temporal(TemporalType.DATE)
    @Column(name="END_DATE")
    private Date endDate;
    
	public WorkBunch() {
		super();
	}

/*
	public WorkBunch(WorkBunch parent) {
    	this.parent = parent;
	}
	public void addChild() {
		getChildList().add(new WorkBunch(this));
	}
 */

    @Override
    public String toString() {
        return "WorkBunch[id=" + getId() + "]";
    }

    public String getCaption(){
        return "[" + getCode() + "] " + getName();
    }
    
	public CTAContact getContact() {
		return contact;
	}

	public void setContact(CTAContact contact) {
		this.contact = contact;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public WorkBunchStatus getWorkBunchStatus() {
		return workBunchStatus;
	}

	public void setWorkBunchStatus(WorkBunchStatus workBunchStatus) {
		this.workBunchStatus = workBunchStatus;
	}

}
