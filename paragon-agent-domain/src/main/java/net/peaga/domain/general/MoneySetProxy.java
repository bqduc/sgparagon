package net.peaga.domain.general;

import java.math.BigDecimal;
import java.util.Currency;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.peaga.domain.base.Repository;

/**
 * 
 * @author ducbq
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class MoneySetProxy extends Repository {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3931133903326134515L;
	private Currency currency;
	
	@Builder.Default
	private BigDecimal value = BigDecimal.ZERO;
	
	@Builder.Default
	private BigDecimal localAmount = BigDecimal.ZERO;

}
