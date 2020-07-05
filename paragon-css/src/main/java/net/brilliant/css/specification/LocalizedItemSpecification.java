/**
 * 
 */
package net.brilliant.css.specification;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import net.brilliant.entity.general.LocalizedItem;
import net.brilliant.framework.model.SearchParameter;
import net.brilliant.framework.model.SearchSpec;
import net.brilliant.framework.specification.CoreSpecifications;

/**
 * @author bqduc
 *
 */
@Builder
public class LocalizedItemSpecification extends CoreSpecifications<LocalizedItem, SearchSpec>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 267373264038078704L;

	public static Specification<LocalizedItem> buildSpecification(final SearchParameter searchParameter) {
		return LocalizedItemSpecification
				.builder()
				.build()
				.buildSpecifications(searchParameter);
	}
}
