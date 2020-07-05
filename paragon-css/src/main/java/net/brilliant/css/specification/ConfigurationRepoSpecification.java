/**
 * 
 */
package net.brilliant.css.specification;

import org.springframework.data.jpa.domain.Specification;

import lombok.Builder;
import net.brilliant.entity.config.Configuration;
import net.brilliant.framework.model.SearchParameter;
import net.brilliant.framework.model.SearchSpec;
import net.brilliant.framework.specification.CoreSpecifications;

/**
 * @author bqduc
 *
 */
@Builder
public class ConfigurationRepoSpecification extends CoreSpecifications<Configuration, SearchSpec>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4115991455691287486L;

	public static Specification<Configuration> buildSpecification(final SearchParameter searchParameter) {
		return ConfigurationRepoSpecification
				.builder()
				.build()
				.buildSpecifications(searchParameter);
	}
}
