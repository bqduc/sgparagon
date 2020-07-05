/**
 * 
 */
package net.brilliant.css.specification;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import net.brilliant.entity.general.BusinessUnit;
import net.brilliant.framework.model.SearchParameter;
import net.brilliant.framework.model.SearchSpec;
import net.brilliant.framework.specification.CoreSpecifications;

/**
 * @author bqduc
 *
 */
@Builder
public class BusinessUnitSpecification extends CoreSpecifications <BusinessUnit, SearchSpec>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5864251508969605374L;

	public static Specification<BusinessUnit> buildSpecification(final SearchParameter searchParameter) {
		return BusinessUnitSpecification
				.builder()
				.build()
				.buildSpecifications(searchParameter);
	}
}
