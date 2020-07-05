/**
 * 
 */
package net.brilliant.framework.predicator;

import org.springframework.data.jpa.domain.Specification;

import net.brilliant.framework.model.SearchParameter;

/**
 * @author bqduc
 *
 */
public abstract class BrilliancePredicator<T> extends RepositoryPredicator<T>{
	public Specification<T> buildSpecification(final SearchParameter searchParameter){
		return predicateSpecification(searchParameter);
	}
}
