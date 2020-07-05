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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import net.brilliant.framework.entity.RepoAuditable;

//FIXME:bankaların yerli mi yabancı mı olduğu bilgisini tutacak bi alan eklemeli.

/**
 * Banka Tanımları 
 * 
 * @author haky
 *
 */
@Entity
@Table(name="BANK")
public class Bank extends RepoAuditable {

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

	@Column(name = "SWIFT_CODE", length = 20, unique = true)
	@Size(max = 20, min = 1)
	private String swiftCode;

	@Column(name = "WORK_BEGIN")
	@Temporal(TemporalType.DATE)
	private Date workBegin;

	@Column(name = "WORK_END")
	@Temporal(TemporalType.DATE)
	private Date workEnd;

	@Column(name = "VALOR")
	private Integer valor;

	@Column(name = "BANK_CODE", length = 35, nullable = false, unique = true)
	@Size(max = 35, min = 3)
	@NotNull
	private String bankCode;

	@Column(name = "WEIGHT")
	private Integer weight;
    /*
    @OneToMany(mappedBy = "bank", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<BankBranch> items = new ArrayList<BankBranch>();
     */

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

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	
	@Override
    public String toString() {
        return "Bank[id=" + getId() + "]";
    }

	public String getSwiftCode() {
		return swiftCode;
	}

	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}
/*
	public List<BankBranch> getItems() {
		return items;
	}

	public void setItems(List<BankBranch> items) {
		this.items = items;
	}
*/	
}
