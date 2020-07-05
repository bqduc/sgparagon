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

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;

import net.brilliant.entity.general.Money;
import net.brilliant.entity.general.MoneySet;
import net.brilliant.entity.general.Quantity;
import net.brilliant.entity.stock.InventoryDetail;
import net.brilliant.framework.entity.RepoEntity;

/**
 * Entity class SpendingNoteItem
 * 
 * @author haky
 */
@Entity
@Table(name="SPENDING_NOTE_ITEM")
public class SpendingNoteItem extends RepoEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name="OWNER_ID")
    private SpendingNote owner;

    @Column(name="LINE_CODE", length=10)
    private String lineCode;
    
    @Column(name="INFO")
    private String info;
    
    @ManyToOne
    @JoinColumn(name="SERVICE_ID")
    private InventoryDetail product;

    @Embedded
    @Valid
    private Quantity quantity = new Quantity();
    
    @Embedded
    @Valid
    @AttributeOverrides({
        @AttributeOverride(name="currency", column=@Column(name="PRICE_CCY", length=3)),
        @AttributeOverride(name="value",    column=@Column(name="PRICE_VALUE",  precision=10, scale=2))
    })
    private Money unitPrice = new Money();
    
    @Embedded
    @Valid
    @AttributeOverrides({
        @AttributeOverride(name="currency", column=@Column(name="AMOUNT_CCY", length=3)),
        @AttributeOverride(name="value",    column=@Column(name="AMOUNT_VALUE", precision=10, scale=2))
    })
    private MoneySet amount = new MoneySet();

    public SpendingNote getOwner() {
        return owner;
    }

    public void setOwner(SpendingNote owner) {
        this.owner = owner;
    }

    public String getLineCode() {
        return lineCode;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public InventoryDetail getProduct() {
		return product;
	}

	public void setProduct(InventoryDetail product) {
		this.product = product;
	}

	public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public Money getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Money unitPrice) {
        this.unitPrice = unitPrice;
    }

    public MoneySet getAmount() {
        return amount;
    }

    public void setAmount(MoneySet amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "com.ut.tekir.entities.SpendingNoteItem[id=" + getId() + "]";
    }
    
}
