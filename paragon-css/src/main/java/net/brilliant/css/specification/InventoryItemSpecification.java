/**
 * 
 */
package net.brilliant.css.specification;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import net.brilliant.entity.stock.InventoryItem;
import net.brilliant.framework.model.SearchParameter;
import net.brilliant.framework.model.SearchSpec;
import net.brilliant.framework.specification.CoreSpecifications;

/**
 * @author bqduc
 *
 */
@Builder
public class InventoryItemSpecification extends CoreSpecifications<InventoryItem, SearchSpec>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4450845076335839837L;

	public static Specification<InventoryItem> buildSpecification(final SearchParameter searchParameter) {
		return InventoryItemSpecification
				.builder()
				.build()
				.buildSpecifications(searchParameter);
	}
}
