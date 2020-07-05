package net.brilliant.entity.stock;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.brilliant.entity.general.TaxGroup;
import net.brilliant.entity.trade.Tax;
import net.brilliant.entity.trade.TaxType;
import net.brilliant.framework.entity.RepoAuditable;

/**
 * Entity class Product profile & it's tax
 * 
 * @author ducbq
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "product_profile_tax")
@EqualsAndHashCode(callSuper=false)
public class ProductProfileTax extends RepoAuditable {
	private static final long serialVersionUID = -5404744703681224962L;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "issued_date")
	private Date issuedDate;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "expired_date")
	private Date expiredDate;

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private InventoryDetail owner;

	@ManyToOne(targetEntity=TaxGroup.class, fetch=FetchType.EAGER)
	@JoinColumn(name = "tax_group_id")
	private TaxGroup taxGroup;

	// KDV - VAT
	@ManyToOne
	@JoinColumn(name = "BUY_TAX_ID")
	private Tax buyTax;

	@ManyToOne
	@JoinColumn(name = "SELL_TAX_ID")
	private Tax sellTax;

	@Builder.Default
	@Column(name = "TAX_INCLUDED")
	private Boolean taxIncluded = Boolean.TRUE;

	// OIV / OTV
	@ManyToOne
	@JoinColumn(name = "BUY_TAX2_ID")
	private Tax buyTax2;

	@ManyToOne
	@JoinColumn(name = "SELL_TAX2_ID")
	private Tax sellTax2;

	@Builder.Default
	@Column(name = "TAX2_INCLUDED")
	private Boolean tax2Included = Boolean.TRUE;

	public Tax getOTVTax() {
		try {
			Method taxGetter = null;
			Tax tax = null;

			for (int i = 1; i <= 5; i++) {
				taxGetter = getClass().getMethod("getSellTax" + i);
				tax = (Tax) taxGetter.invoke(this);

				if (tax != null && tax.getType().equals(TaxType.OTV)) {
					return tax;
				}
			}
		} catch (Exception e) {
			System.out.println("Hata" + e.getMessage());
		}
		return null;
	}

	/**
	 * will use to tax taxes.
	 */
	@Transient
	private List<ProductTax> taxList;

	public List<ProductTax> taxesAsList() {
		if (taxList == null) {
			taxList = new ArrayList<ProductTax>();

			taxList.add(new ProductTax(getBuyTax(), getTaxIncluded()));
			taxList.add(new ProductTax(getBuyTax2(), getTax2Included()));
		}
		return taxList;
	}

	public ProductTax getWitholdingTax() {
		for (ProductTax productTax : taxesAsList()) {
			if (productTax.getTax() != null && productTax.getTax().getType().equals(TaxType.STOPAJ))
				return productTax;
		}
		return null;
	}
}
