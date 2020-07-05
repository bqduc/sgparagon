/**
 * 
 */
package net.brilliant.css.specification;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import net.brilliant.entity.contact.CTAContact;
import net.brilliant.framework.model.SearchParameter;
import net.brilliant.framework.model.SearchSpec;
import net.brilliant.framework.specification.CoreSpecifications;

/**
 * @author bqduc
 *
 */
@Builder
public class ContactSpecification extends CoreSpecifications<CTAContact, SearchSpec>{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4351535957683794972L;

	public static Specification<CTAContact> buildSpecification(final SearchParameter searchParameter) {
		return ContactSpecification
				.builder()
				.build()
				.buildSpecifications(searchParameter);
	}
}
