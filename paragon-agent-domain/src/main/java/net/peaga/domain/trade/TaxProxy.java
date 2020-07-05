/**
 * 
 */
package net.peaga.domain.trade;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.peaga.domain.base.Repository;
import net.peaga.domain.enums.TaxType;

/**
 * @author ducbq
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class TaxProxy extends Repository {
	private static final long serialVersionUID = 5587129756345820325L;

	private java.lang.String code;
	private java.lang.String name;
	private java.lang.String info;

	private TaxType type;

	@Builder.Default
	private Boolean isTransportTax = Boolean.FALSE;

	private TaxProxy parent;
	private TaxGroupProxy group;

	private Date commencementDate;
}
