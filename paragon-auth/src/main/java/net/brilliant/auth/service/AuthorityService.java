package net.brilliant.auth.service;

import org.springframework.data.domain.Page;

import net.brilliant.auth.entity.Authority;
import net.brilliant.exceptions.ObjectNotFoundException;
import net.brilliant.framework.model.SearchParameter;
import net.brilliant.framework.service.GenericService;

public interface AuthorityService extends GenericService<Authority, Long> {

	/**
	 * Get one Authority with the provided code.
	 * 
	 * @param name
	 *            The Authority name
	 * @return The Authority
	 * @throws ObjectNotFoundException
	 *             If no such Authority exists.
	 */
	Authority getByName(String name) throws ObjectNotFoundException;

	/**
	 * Get one Authoritys with the provided search parameters.
	 * 
	 * @param searchParameter
	 *            The search parameter
	 * @return The pageable Authorities
	 */
	Page<Authority> getObjects(SearchParameter searchParameter);

	
	/**
	 * Get one Authority with the provided code.
	 * 
	 * @param name
	 *            The Authority name
	 * @return The Authority
	 * @throws ObjectNotFoundException
	 *             If no such Authority exists.
	 */
	Authority getMinimumUserAuthority() throws ObjectNotFoundException;
}
