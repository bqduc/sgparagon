/**
 * 
 */
package net.brilliant.css.specification;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import net.brilliant.entity.system.Sequence;
import net.brilliant.framework.model.SearchParameter;
import net.brilliant.framework.model.SearchSpec;
import net.brilliant.framework.specification.CoreSpecifications;

/**
 * @author bqduc
 *
 */
@Builder
public class SequenceSpecification extends CoreSpecifications <Sequence, SearchSpec>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9124997437694609911L;

	public static Specification<Sequence> buildSpecification(final SearchParameter searchParameter) {
		return SequenceSpecification
				.builder()
				.build()
				.buildSpecifications(searchParameter);
	}
}
