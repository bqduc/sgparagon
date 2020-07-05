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

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import net.brilliant.entity.doc.DocumentType;
import net.brilliant.entity.general.MoneySet;
import net.brilliant.entity.general.WorkBunch;
import net.brilliant.framework.entity.RepoAuditable;

@Entity
@Table(name="BANK_TXN")
public class BankTxn extends RepoAuditable {

	private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name="BANK_ACCOUNT_ID")
    private BankAccount bankAccount;
    
    @Column(name="ADVERSE_CODE", length=20)
    @Size(max=20)
    private String adverseCode;
    
    @Column(name="ADVERSE_NAME", length=250)
    @Size(max=250)
    private String adverseName;
    
    @Column(name="TXNDATE")
    @Temporal(value=TemporalType.DATE)
    private Date date;
    
    @Column(name="ACTION")
    @Enumerated(EnumType.ORDINAL)
    private FinanceAction action;

    @Column(name="ACTION_TYPE")
    @Enumerated(EnumType.ORDINAL)
    private FinanceActionType actionType = FinanceActionType.Capital;

    @Embedded
    @Valid
    @AttributeOverrides( {
        @AttributeOverride(name="currency", column=@Column(name="CCY")),
        @AttributeOverride(name="value",    column=@Column(name="CCYVAL")),
        @AttributeOverride(name="localAmount", column=@Column(name="LCYVAL"))
    })
    private MoneySet amount = new MoneySet();
    
    @Column(name="CODE", length=15)
    @Size(max=15)
    private String code;
    
    @Column(name="INFO")
    private String info;
    
    @Column(name="SERIAL", length=10)
    @Size(max=10)
    private String serial;
    
    @Column(name="REFERENCE", length=10)
    @Size(max=10)
    private String reference;
    
    //TODO: Banka hesasplarıda çek bono v.b. tutulduğunda bu detay netleşecek
    //private PaymentType fundType;
    @Column(name="DOCUMENT_TYPE")
    @Enumerated(EnumType.ORDINAL)
    private DocumentType documentType;
    
    @Column(name="DOCUMENTID")
    private Long documentId;

    @Column(name="PROCESS_TYPE")
    @Enumerated(EnumType.ORDINAL)
    private AdvanceProcessType processType = AdvanceProcessType.Normal;
    
    @ManyToOne
    @JoinColumn(name="WORK_BUNCH_ID", foreignKey = @ForeignKey(name = "FK_BANKTXN_WORKBUNCHID"))
    private WorkBunch workBunch;

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public FinanceAction getAction() {
		return action;
	}

	public void setAction(FinanceAction action) {
		this.action = action;
	}

	public MoneySet getAmount() {
		return amount;
	}

	public void setAmount(MoneySet amount) {
		this.amount = amount;
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

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public Long getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}

    public FinanceActionType getActionType() {
        return actionType;
    }

    public void setActionType(FinanceActionType actionType) {
        this.actionType = actionType;
    }

	@Override
    public String toString() {
        return "BankTxn[id=" + getId() + "]";
    }

	public void setAdverseCode(String adverseCode) {
		this.adverseCode = adverseCode;
	}

	public String getAdverseCode() {
		return adverseCode;
	}

	public void setAdverseName(String adverseName) {
		this.adverseName = adverseName;
	}

	public String getAdverseName() {
		return adverseName;
	}

	public WorkBunch getWorkBunch() {
		return workBunch;
	}

	public void setWorkBunch(WorkBunch workBunch) {
		this.workBunch = workBunch;
	}

	public AdvanceProcessType getProcessType() {
		return processType;
	}

	public void setProcessType(AdvanceProcessType processType) {
		this.processType = processType;
	}

}
