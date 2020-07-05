/**
 * 
 */
package net.brilliant.css.specification;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import net.brilliant.domain.entity.general.CatalogueSubtype;
import net.brilliant.framework.model.SearchParameter;
import net.brilliant.framework.model.SearchSpec;
import net.brilliant.framework.specification.CoreSpecifications;

/**
 * @author bqduc
 *
 */
@Builder
public class CatalogueSubtypeSpecification extends CoreSpecifications<CatalogueSubtype, SearchSpec>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2021774340255996625L;

	public static Specification<CatalogueSubtype> buildSpecification(final SearchParameter searchParameter) {
		return CatalogueSubtypeSpecification
				.builder()
				.build()
				.buildSpecifications(searchParameter);
	}
}
