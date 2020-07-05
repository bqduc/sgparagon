/**
 * 
 */
package net.brilliant.framework.specification;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import net.brilliant.framework.model.SearchParameter;

/**
 * @author bqduc
 *
 */
@Builder
public class DefaultSpecification<UserType, UserRequest> extends CoreSpecifications<UserType, UserRequest>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8048207998918786365L;

	public Specification<UserType> buildSpecification(final SearchParameter searchParameter) {
		return super.buildSpecifications(searchParameter);
	}
}
