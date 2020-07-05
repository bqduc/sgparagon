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

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.validation.Valid;

import net.brilliant.entity.general.MoneySet;
import net.brilliant.framework.entity.RepoEntity;

/**
 * Dökümanların satırlarındaki ortak bilgileri tutar.
 * 
 * @author sinan.yumak
 * 
 */
@MappedSuperclass
public abstract class DocumentItemBase  extends RepoEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5883594273417546375L;

    @Embedded
    @Valid
    @AttributeOverrides( {
        @AttributeOverride(name="currency", column=@Column(name="AMOUNT_CCY")),
        @AttributeOverride(name="value",    column=@Column(name="AMOUNT_VALUE")),
        @AttributeOverride(name="localAmount",    column=@Column(name="AMOUNT_LCYVAL"))
    })
    private MoneySet amount = new MoneySet();

//	public abstract DocumentBase getOwner();
//	public abstract void setOwner(DocumentBase document);
	
	public MoneySet getAmount() {
		return amount;
	}

	public void setAmount(MoneySet amount) {
		this.amount = amount;
	}
	
}
