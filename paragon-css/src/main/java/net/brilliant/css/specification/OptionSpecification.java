/**
 * 
 */
package net.brilliant.css.specification;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import net.brilliant.entity.system.Option;
import net.brilliant.framework.model.SearchParameter;
import net.brilliant.framework.model.SearchSpec;
import net.brilliant.framework.specification.CoreSpecifications;

/**
 * @author bqduc
 *
 */
@Builder
public class OptionSpecification extends CoreSpecifications<Option, SearchSpec>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3900233288875704002L;

	public static Specification<Option> buildSpecification(final SearchParameter searchParameter) {
		return OptionSpecification
				.builder()
				.build()
				.buildSpecifications(searchParameter);
	}
}
