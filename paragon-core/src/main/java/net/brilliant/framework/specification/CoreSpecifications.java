/**
 * 
 */
package net.brilliant.framework.specification;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import net.brilliant.common.CommonUtility;
import net.brilliant.common.ListUtility;
import net.brilliant.framework.model.SearchParameter;

/**
 * @author bqduc
 *
 */
public abstract class CoreSpecifications<UserType, UserRequest> extends BaseSpecification<UserType, UserRequest>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Specification<UserType> getFilter(UserRequest userRequest) {
		return null;
	}

	protected Specification<UserType> buildSpecifications(final SearchParameter searchParameter){
		return new Specification<UserType>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 369798785793130829L;

			@Override
			public Predicate toPredicate(Root<UserType> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				Predicate[] predicatesArray = null;
				Object searchValue = null;
				List<Predicate> predicates = ListUtility.createArrayList();
				//predicates = buildPredicates(searchParameter, root, builder);
				if (CommonUtility.isNotEmpty(searchParameter.getParameterMap())){
					for (String searchParam :searchParameter.getParameterMap().keySet()){
						searchValue = searchParameter.getParameterMap().get(searchParam);
						if (CommonUtility.isNotEmpty(searchValue)){
							if (searchValue instanceof String){
								predicates.add(builder.and(builder.like(root.get(searchParam), containsWildcard((String)searchParameter.getParameterMap().get(searchParam)))));
							}else if (searchValue instanceof java.util.Date){
								predicates.add(builder.and(builder.between(root.get(searchParam), (java.util.Date)searchValue, (java.util.Date)searchValue)));
							}
						}
					}
				}
				predicatesArray = new Predicate[predicates.size()];
				return builder.and(predicates.toArray(predicatesArray));
			}
		};
	}

	public Specification<UserType> buildRepoSpecification(final SearchParameter searchParameter) {
		return this.buildSpecifications(searchParameter);
	}
}
