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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;

import net.brilliant.framework.entity.RepoEntity;

@Entity
@Table(name="PAYMENT_PLAN")
public class PaymentPlan extends RepoEntity {

	private static final long serialVersionUID = 1L;
    @Column(name="CODE", length=20, unique=true, nullable=false)
	private String code;

    @Column(name="NAME", length=50)
    private String name;
    
    @Column(name="INFO")
	private String info;
    
    @Column(name="ISACTIVE")
	private Boolean active = Boolean.TRUE;

    @Column(name="VALIDITY_START_DATE")
    @Temporal(value = TemporalType.DATE)
    private Date validityStartDate;

    @Column(name="VALIDITY_END_DATE")
    @Temporal(value = TemporalType.DATE)
    private Date validityEndDate;

    @OneToMany(mappedBy="paymentPlan", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    private List<PaymentPlanItem> items = new ArrayList<PaymentPlanItem>();

	@Column(name="PAYMENT_DAY")
	private String paymentDay = "Mon;Tue;Wed;Thu;Fri;";

	@Transient
	private boolean firstDay = true;

	@Transient
	private boolean secondDay = true;
	
	@Transient
	private boolean thirdDay = true;
	
	@Transient
	private boolean fourthDay = true;

	@Transient
	private boolean fifthDay = true;
	
	@Transient
	private boolean sixthDay = true;
	
	@Transient
	private boolean seventhDay = true;

    /**
     * Ödemenin yapılacağı hafta bilgisini tutar.
     */
	@Column(name="PAYMENT_WEEK")
	private String paymentWeek = "First;Second;Third;Fourth;Fifth;";
	
	@Transient
	private boolean firstWeek = true;

	@Transient
	private boolean secondWeek = true;
	
	@Transient
	private boolean thirdWeek = true;
	
	@Transient
	private boolean fourthWeek = true;

	@Transient
	private boolean fifthWeek = true;

	public List<Boolean> paymentDaysAsList() {
		List<Boolean> result = new ArrayList<Boolean>();

		//pazardan başlayarak...
		result.add(seventhDay);
		result.add(firstDay);
		result.add(secondDay);
		result.add(thirdDay);
		result.add(fourthDay);
		result.add(fifthDay);
		result.add(sixthDay);
		return result;
	}

	public List<Boolean> paymentWeeksAsList() {
		List<Boolean> result = new ArrayList<Boolean>();
		
		//pazardan başlayarak...
		result.add(firstWeek);
		result.add(secondWeek);
		result.add(thirdWeek);
		result.add(fourthWeek);
		result.add(fifthWeek);
		return result;
	}

	public void convertPaymentWeeksToString() {
    	StringBuilder weekList =  new StringBuilder();
    	if (isFirstWeek()) {
    		weekList.append("First;");
    	}
    	if (isSecondWeek()) {
    		weekList.append("Second;");
    	}
    	if (isThirdWeek()) {
    		weekList.append("Third;");
    	}
    	if (isFourthWeek()) {
    		weekList.append("Fourth;");
    	}
    	if (isFifthWeek()) {
    		weekList.append("Fifth;");
    	}
    	setPaymentWeek(weekList.toString());
    }

    public void convertPaymentStringToWeeks() {
    	String[] weekList= null;

    	weekList = getPaymentWeek().split(";");
    		
		setFirstWeek(false);
		setSecondWeek(false);
		setThirdWeek(false);
		setFourthWeek(false);
		setFifthWeek(false);

		for (String week : weekList) {

			if (week.equals("First")) {
				setFirstWeek(true);
			} 
			if (week.equals("Second")){
				setSecondWeek(true);
			}
			if (week.equals("Third")){
				setThirdWeek(true);
			}
			if (week.equals("Fourth")){
				setFourthWeek(true);
			}
			if (week.equals("Fifth")){
				setFifthWeek(true);
			}
		}
    }

    public void convertPaymentStringToDays() {
    	String[] dayList= null;

    	dayList = getPaymentDay().split(";");
    		
		setFirstDay(false);
		setSecondDay(false);
		setThirdDay(false);
		setFourthDay(false);
		setFifthDay(false);
		setSixthDay(false);
		setSeventhDay(false);

		for (String day : dayList) {

			if (day.equals("Mon")) {
				setFirstDay(true);
			} 
			if (day.equals("Tue")){
				setSecondDay(true);
			}
			if (day.equals("Wed")){
				setThirdDay(true);
			}
			if (day.equals("Thu")){
				setFourthDay(true);
			}
			if (day.equals("Fri")){
				setFifthDay(true);
			}
			if (day.equals("Sat")){
				setSixthDay(true);
			}
			if (day.equals("Sun")){
				setSeventhDay(true);
			}
		}
    }

    public void convertPaymentDaysToString() {
    	StringBuilder dayList =  new StringBuilder();
		if (isFirstDay()) {
			dayList.append("Mon;");
		}
		if (isSecondDay()) {
			dayList.append("Tue;");
		}
		if (isThirdDay()) {
			dayList.append("Wed;");
		}
		if (isFourthDay()) {
			dayList.append("Thu;");
		}
		if (isFifthDay()) {
			dayList.append("Fri;");
		}
		if (isSixthDay()) {
			dayList.append("Sat;");
		}
		if (isSeventhDay()) {
			dayList.append("Sun;");
		}
		setPaymentDay(dayList.toString());
    }
    
	public Date getValidityStartDate() {
		return validityStartDate;
	}

	public void setValidityStartDate(Date validityStartDate) {
		this.validityStartDate = validityStartDate;
	}

	public Date getValidityEndDate() {
		return validityEndDate;
	}

	public void setValidityEndDate(Date validityEndDate) {
		this.validityEndDate = validityEndDate;
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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<PaymentPlanItem> getItems() {
		return items;
	}

	public void setItems(List<PaymentPlanItem> items) {
		this.items = items;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (getId() != null ? getId().hashCode() : 0);
		return hash;
	}

	@Override
	public String toString() {
		return "PaymentPlan[id=" + getId() + "]";
	}

	public String getPaymentDay() {
		return paymentDay;
	}

	public void setPaymentDay(String paymentDay) {
		this.paymentDay = paymentDay;
	}

	public boolean isFirstDay() {
		return firstDay;
	}

	public void setFirstDay(boolean firstDay) {
		this.firstDay = firstDay;
	}

	public boolean isSecondDay() {
		return secondDay;
	}

	public void setSecondDay(boolean secondDay) {
		this.secondDay = secondDay;
	}

	public boolean isThirdDay() {
		return thirdDay;
	}

	public void setThirdDay(boolean thirdDay) {
		this.thirdDay = thirdDay;
	}

	public boolean isFourthDay() {
		return fourthDay;
	}

	public void setFourthDay(boolean fourthDay) {
		this.fourthDay = fourthDay;
	}

	public boolean isFifthDay() {
		return fifthDay;
	}

	public void setFifthDay(boolean fifthDay) {
		this.fifthDay = fifthDay;
	}

	public boolean isSixthDay() {
		return sixthDay;
	}

	public void setSixthDay(boolean sixthDay) {
		this.sixthDay = sixthDay;
	}

	public boolean isSeventhDay() {
		return seventhDay;
	}

	public void setSeventhDay(boolean seventhDay) {
		this.seventhDay = seventhDay;
	}

	public String getPaymentWeek() {
		return paymentWeek;
	}

	public void setPaymentWeek(String paymentWeek) {
		this.paymentWeek = paymentWeek;
	}

	public boolean isFirstWeek() {
		return firstWeek;
	}

	public void setFirstWeek(boolean firstWeek) {
		this.firstWeek = firstWeek;
	}

	public boolean isSecondWeek() {
		return secondWeek;
	}

	public void setSecondWeek(boolean secondWeek) {
		this.secondWeek = secondWeek;
	}

	public boolean isThirdWeek() {
		return thirdWeek;
	}

	public void setThirdWeek(boolean thirdWeek) {
		this.thirdWeek = thirdWeek;
	}

	public boolean isFourthWeek() {
		return fourthWeek;
	}

	public void setFourthWeek(boolean fourthWeek) {
		this.fourthWeek = fourthWeek;
	}

	public boolean isFifthWeek() {
		return fifthWeek;
	}

	public void setFifthWeek(boolean fifthWeek) {
		this.fifthWeek = fifthWeek;
	}
	
}
