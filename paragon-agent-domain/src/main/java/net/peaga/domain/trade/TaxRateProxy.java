/**
 * 
 */
package net.peaga.domain.trade;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.peaga.domain.base.Repository;
import net.peaga.domain.enums.TaxKind;
import net.peaga.domain.general.MoneySetProxy;

/**
 * @author ducbq
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class TaxRateProxy extends Repository {
	private static final long serialVersionUID = 5006182957195168698L;
	private java.lang.String info;
	private java.lang.String name;

	private TaxProxy tax;

	private Date beginDate;

	private Date endDate;

	@Builder.Default
	private TaxKind kind = TaxKind.Rate;

	// If the tax type is selected as a percentage, if the fraction is selected, it keeps the denominator.
	@Builder.Default
	private BigDecimal rate = BigDecimal.ZERO;

  // area to be used if tax is to be kept as amount ..
	@Builder.Default
  private MoneySetProxy amount = MoneySetProxy.builder().build();

	/**
	 * Withholding tax related fields ...
	 */
	private TaxKind withholdingKind;

	// It is the area to be used if the withholding type holds. It will be in the same currency as the line amount.
	@Builder.Default
	private BigDecimal withholdingAmount = BigDecimal.ZERO;

	@Builder.Default
	private BigDecimal withholdingRate = BigDecimal.ZERO;	
}
