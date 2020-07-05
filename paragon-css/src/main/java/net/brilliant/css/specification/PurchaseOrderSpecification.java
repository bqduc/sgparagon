/**
 * 
 */
package net.brilliant.css.specification;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import net.brilliant.entity.emx.PurchaseOrder;
import net.brilliant.framework.model.SearchParameter;
import net.brilliant.framework.model.SearchSpec;
import net.brilliant.framework.specification.CoreSpecifications;

/**
 * @author bqduc
 *
 */
@Builder
public class PurchaseOrderSpecification extends CoreSpecifications<PurchaseOrder, SearchSpec>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4608364667950258805L;

	public static Specification<PurchaseOrder> buildSpecification(final SearchParameter searchParameter) {
		return PurchaseOrderSpecification
				.builder()
				.build()
				.buildSpecifications(searchParameter);
	}
}
