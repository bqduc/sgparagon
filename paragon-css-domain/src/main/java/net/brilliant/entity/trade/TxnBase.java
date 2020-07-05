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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import net.brilliant.entity.doc.DocumentType;
import net.brilliant.entity.general.MoneySet;
import net.brilliant.framework.entity.RepoAuditable;

/**
 * Txn tabloları için kullanacağımız ortak sınıftır.
 * @author "sinan.yumak"
 *
 */
@MappedSuperclass
public class TxnBase extends RepoAuditable {
	private static final long serialVersionUID = 1L;

    @Column(name="TXN_DATE")
    @Temporal(value=TemporalType.DATE)
    private Date date;
    
    @Column(name="FINANCE_ACTION")
    @Enumerated(EnumType.ORDINAL)
    private FinanceAction action;
    
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
        
    @Column(name="DOCUMENT_TYPE")
    @Enumerated(EnumType.ORDINAL)
    private DocumentType documentType;
    
    @Column(name="DOCUMENT_ID")
    private Long documentId;

    @Column(name="ADVERSE_CODE", length=20)
    @Size(max=20)
    private String adverseCode;
    
    @Column(name="ADVERSE_NAME", length=250)
    @Size(max=250)
    private String adverseName;

    /**
     * Gerçekte ödenecek tutardır.
     */
    @Embedded
    @Valid
    @AttributeOverrides( {
        @AttributeOverride(name="currency", column=@Column(name="CCY")),
        @AttributeOverride(name="value",    column=@Column(name="CCYVAL")),
        @AttributeOverride(name="localAmount", column=@Column(name="LCYVAL"))
    })
    private MoneySet amount = new MoneySet();

    @Column(name="REPAID_STATUS")
    private boolean repaidStatus = false;
    
	/**
	 * Eğer satırın geri ödemesi yapıldı ise, hangi fatura veya 
	 * hangi transfer fişi ile yapıldığı bilgisini tutar.
	 */
	@Column(name="REFERENCE_ID")
	private Long referenceId;
	
    @Column(name="REFERENCE_DOC_TYPE")
    @Enumerated(EnumType.ORDINAL)
    private DocumentType referenceDocumentType;

    @Override
    public String toString() {
        return "TxnBase[id=" + getId() + "]";
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

	public String getAdverseCode() {
		return adverseCode;
	}

	public void setAdverseCode(String adverseCode) {
		this.adverseCode = adverseCode;
	}

	public String getAdverseName() {
		return adverseName;
	}

	public void setAdverseName(String adverseName) {
		this.adverseName = adverseName;
	}

	public MoneySet getAmount() {
		return amount;
	}

	public void setAmount(MoneySet amount) {
		this.amount = amount;
	}

	public boolean isRepaidStatus() {
		return repaidStatus;
	}

	public void setRepaidStatus(boolean repaidStatus) {
		this.repaidStatus = repaidStatus;
	}

	public Long getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(Long referenceId) {
		this.referenceId = referenceId;
	}

	public DocumentType getReferenceDocumentType() {
		return referenceDocumentType;
	}

	public void setReferenceDocumentType(DocumentType referenceDocumentType) {
		this.referenceDocumentType = referenceDocumentType;
	}

}
