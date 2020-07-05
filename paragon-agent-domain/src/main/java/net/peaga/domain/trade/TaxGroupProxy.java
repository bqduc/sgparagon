/**
 * 
 */
package net.peaga.domain.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.peaga.domain.base.Repository;

/**
 * @author ducbq
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class TaxGroupProxy extends Repository {
	private static final long serialVersionUID = -85105194150877766L;

	private java.lang.String info;
	private java.lang.String name;

	private TaxGroupProxy parent;
}
