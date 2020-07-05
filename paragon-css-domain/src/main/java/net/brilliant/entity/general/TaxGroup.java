package net.brilliant.entity.general;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import net.brilliant.entity.base.BaseTaxGroup;

@Entity
@Table(name = "tax_group")
@EqualsAndHashCode(callSuper = true)
public class TaxGroup extends BaseTaxGroup {
	private static final long serialVersionUID = 1L;

	@Setter
	@Getter
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private TaxGroup parent;

	@Setter
	@Getter
	@Column(name = "INFO")
	private String info;
	
	public TaxGroup() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public TaxGroup(java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public TaxGroup(java.lang.Long id, java.lang.String name) {

		super(id, name);
	}

	@Override
	public String toString() {
		String name = super.getName();
		List<PosTax> taxes = getTaxes();
		if (taxes == null || taxes.isEmpty()) {
			return name;
		}
		name += " (";
		for (Iterator<?> iterator = taxes.iterator(); iterator.hasNext();) {
			PosTax tax = (PosTax) iterator.next();
			name += tax.getName() + ":" + tax.getRate();
			if (iterator.hasNext()) {
				name += ", ";
			}
		}
		name += ")";
		return name;
	}

}