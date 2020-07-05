/**
 * 
 */
package net.brilliant.css.specification;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import net.brilliant.entity.general.MeasureUnit;
import net.brilliant.framework.model.SearchParameter;
import net.brilliant.framework.model.SearchSpec;
import net.brilliant.framework.specification.CoreSpecifications;

/**
 * @author bqduc
 *
 */
@Builder
public class MeasureUnitSpecification extends CoreSpecifications<MeasureUnit, SearchSpec>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7455339506976096038L;

	public static Specification<MeasureUnit> buildSpecification(final SearchParameter searchParameter) {
		return MeasureUnitSpecification
				.builder()
				.build()
				.buildSpecifications(searchParameter);
	}
}
