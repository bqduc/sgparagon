/**
 * 
 */
package net.brilliant.css.specification;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import net.brilliant.domain.entity.general.Catalogue;
import net.brilliant.framework.model.SearchParameter;
import net.brilliant.framework.model.SearchSpec;
import net.brilliant.framework.specification.CoreSpecifications;

/**
 * @author bqduc
 *
 */
@Builder
public class CatalogueSpecification extends CoreSpecifications<Catalogue, SearchSpec>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2021774340255996625L;

	public static Specification<Catalogue> buildSpecification(final SearchParameter searchParameter) {
		return CatalogueSpecification
				.builder()
				.build()
				.buildSpecifications(searchParameter);
	}
}
