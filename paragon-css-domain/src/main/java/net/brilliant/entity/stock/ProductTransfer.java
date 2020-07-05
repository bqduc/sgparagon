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

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.brilliant.entity.doc.DocumentBase;
import net.brilliant.entity.doc.DocumentType;

/**
 * Entity class ProductTransfer
 * 
 * @author haky
 */
@Entity
@Table(name="PRODUCT_TRANSFER")
public class ProductTransfer extends DocumentBase {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name="FROM_WAREHOUSE_ID")
    private Warehouse fromWarehouse;

    @ManyToOne
    @JoinColumn(name="TO_WAREHOUSE_ID")
    private Warehouse toWarehouse;
    
    @OneToMany(mappedBy="owner", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<ProductTransferItem> items = new ArrayList<ProductTransferItem>();

    @Override
	public DocumentType getDocumentType() {
		return DocumentType.ProductTransfer;
	}

    public Warehouse getFromWarehouse() {
        return fromWarehouse;
    }

    public void setFromWarehouse(Warehouse fromWarehouse) {
        this.fromWarehouse = fromWarehouse;
    }

    public Warehouse getToWarehouse() {
        return toWarehouse;
    }

    public void setToWarehouse(Warehouse toWarehouse) {
        this.toWarehouse = toWarehouse;
    }

    public List<ProductTransferItem> getItems() {
        return items;
    }

    public void setItems(List<ProductTransferItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ProductTransfer[id=" + getId() + "]";
    }
    
}
