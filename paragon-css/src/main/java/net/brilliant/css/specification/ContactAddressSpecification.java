/**
 * 
 */
package net.brilliant.css.specification;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import net.brilliant.entity.contact.ContactAddress;
import net.brilliant.framework.model.SearchParameter;
import net.brilliant.framework.model.SearchSpec;
import net.brilliant.framework.specification.CoreSpecifications;

/**
 * @author bqduc
 *
 */
@Builder
public class ContactAddressSpecification extends CoreSpecifications <ContactAddress, SearchSpec>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4984760941753997036L;

	public static Specification<ContactAddress> buildSpecification(final SearchParameter searchParameter) {
		return ContactAddressSpecification
				.builder()
				.build()
				.buildSpecifications(searchParameter);
	}
}
