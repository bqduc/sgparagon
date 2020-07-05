/**
 * 
 */
package net.brilliant.auth.specification;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import net.brilliant.auth.entity.Authority;
import net.brilliant.framework.model.SearchParameter;
import net.brilliant.framework.model.SearchSpec;
import net.brilliant.framework.specification.CoreSpecifications;

/**
 * @author bqduc
 *
 */
@Builder
public class AuthoritySpecification extends CoreSpecifications<Authority, SearchSpec>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2021774340255996625L;

	public static Specification<Authority> buildSpecification(final SearchParameter searchParameter) {
		return AuthoritySpecification
				.builder()
				.build()
				.buildSpecifications(searchParameter);
	}
}
