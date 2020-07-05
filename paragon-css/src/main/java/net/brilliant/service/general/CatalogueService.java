package net.brilliant.service.general;

import java.util.Optional;

import org.springframework.data.domain.Page;

import net.brilliant.domain.entity.general.Catalogue;
import net.brilliant.exceptions.ObjectNotFoundException;
import net.brilliant.framework.model.SearchParameter;
import net.brilliant.framework.service.GenericService;

public interface CatalogueService extends GenericService<Catalogue, Long> {

	/**
	 * Get one Catalogue with the provided name.
	 * 
	 * @param name
	 *            The Catalogue name
	 * @return The Catalogue
	 * @throws ObjectNotFoundException
	 *             If no such Catalogue exists.
	 */
	Optional<Catalogue> getByName(String name) throws ObjectNotFoundException;

	/**
	 * Get one Catalogue with the provided code.
	 * 
	 * @param code
	 *            The Catalogue code
	 * @return The Catalogue
	 * @throws ObjectNotFoundException
	 *             If no such Catalogue exists.
	 */
	Optional<Catalogue> getByCode(String code) throws ObjectNotFoundException;

	/**
	 * Get one Catalogues with the provided search parameters.
	 * 
	 * @param searchParameter
	 *            The search parameter
	 * @return The pageable Catalogues
	 */
	Page<Catalogue> getObjects(SearchParameter searchParameter);

}
