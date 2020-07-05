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

package net.brilliant.entity.stock;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import net.brilliant.entity.general.Quantity;
import net.brilliant.framework.entity.RepoEntity;

/**
 * Entity class ProductTransferItem
 * 
 * @author haky
 */
@Entity
@Table(name="PRODUCT_TRANSFER_ITEM")
public class ProductTransferItem extends RepoEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name="OWNER_ID")
    private ProductTransfer owner;
    
    @ManyToOne
    @JoinColumn(name="PRODUCT_ID")
    private InventoryDetail product;

    @Column(name="INFO")
    private String info;
    
    @Column(name="LINE_CODE", length=10)
    @Size(max=10)
    private String lineCode;
    
    @Embedded
    @Valid
    private Quantity quantity = new Quantity();

    public ProductTransfer getOwner() {
        return owner;
    }

    public void setOwner(ProductTransfer owner) {
        this.owner = owner;
    }

    public InventoryDetail getProduct() {
        return product;
    }

    public void setProduct(InventoryDetail product) {
        this.product = product;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getLineCode() {
        return lineCode;
    }

    public void setLineCode(String lineCode) {
        this.lineCode = lineCode;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ProductTransferItem[id=" + getId() + "]";
    }
    
}
