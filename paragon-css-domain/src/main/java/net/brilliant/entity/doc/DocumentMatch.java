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

package net.brilliant.entity.doc;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import net.brilliant.entity.general.MoneySet;
import net.brilliant.framework.entity.RepoEntity;


/**
 * Döküman eşleme bilgilerini tutar...
 *
 * @author sinan.yumak
 *
 */
@Entity
@Table(name="DOCUMENT_MATCH")
public class DocumentMatch extends RepoEntity {
	private static final long serialVersionUID = 1L;

	@Column(name="DOCUMENT_TYPE")
	@Enumerated(EnumType.ORDINAL)
	private DocumentType documentType;

	@Column(name="DOCUMENT_SERIAL")
	private String documentSerial;

	@Column(name="DOCUMENT_ID")
	private Long documentId;
	
    @Column(name="MATCH_DATE")
    @Temporal(TemporalType.DATE)
	private Date matchDate;

    //FIXME: burayı moneyset sınıfına çevirmek gerekebilir.
    //Çünkü eşlemeler farklı döviz türleri ile gerçekleştirilebilir.
    /**
	 * Eşlemenin tutarıdır.
	 */
    @Embedded
    @AttributeOverrides( {
        @AttributeOverride(name="currency", column=@Column(name="AMOUNT_CCY")),
        @AttributeOverride(name="value",    column=@Column(name="AMOUNT_VALUE")),
        @AttributeOverride(name="localAmount",    column=@Column(name="AMOUNT_LCYVAL"))
    })
    private MoneySet amount = new MoneySet();

	@Column(name="MATCHED_DOCUMENT_TYPE")
	@Enumerated(EnumType.ORDINAL)
	private DocumentType matchedDocumentType;

	@Column(name="MATCHED_DOCUMENT_SERIAL")
	private String matchedDocumentSerial;

    @Column(name="MATCHED_DOCUMENT_ID")
    private Long matchedDocumentId;

	public Date getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}

	public DocumentType getMatchedDocumentType() {
		return matchedDocumentType;
	}

	public void setMatchedDocumentType(DocumentType matchedDocumentType) {
		this.matchedDocumentType = matchedDocumentType;
	}

	public String getMatchedDocumentSerial() {
		return matchedDocumentSerial;
	}

	public void setMatchedDocumentSerial(String matchedDocumentSerial) {
		this.matchedDocumentSerial = matchedDocumentSerial;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	public String getDocumentSerial() {
		return documentSerial;
	}

	public void setDocumentSerial(String documentSerial) {
		this.documentSerial = documentSerial;
	}

	@Override
    public String toString() {
        return "DocumentMatch[id=" + getId() + "]";
    }

    public Long getMatchedDocumentId() {
        return matchedDocumentId;
    }

    public void setMatchedDocumentId(Long matchedDocumentId) {
        this.matchedDocumentId = matchedDocumentId;
    }

	public Long getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}

	public MoneySet getAmount() {
		return amount;
	}

	public void setAmount(MoneySet amount) {
		this.amount = amount;
	}
}
