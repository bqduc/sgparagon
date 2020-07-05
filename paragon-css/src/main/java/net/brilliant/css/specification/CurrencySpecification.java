/**
 * 
 */
package net.brilliant.css.specification;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import net.brilliant.entity.general.Currency;
import net.brilliant.framework.model.SearchParameter;
import net.brilliant.framework.model.SearchSpec;
import net.brilliant.framework.specification.CoreSpecifications;

/**
 * @author bqduc
 *
 */
@Builder
public class CurrencySpecification extends CoreSpecifications<Currency, SearchSpec>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7455339506976096038L;

	public static Specification<Currency> buildSpecification(final SearchParameter searchParameter) {
		return CurrencySpecification
				.builder()
				.build()
				.buildSpecifications(searchParameter);
	}
}
