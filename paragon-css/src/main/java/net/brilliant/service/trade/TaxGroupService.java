package net.brilliant.service.trade;

import java.util.Optional;

import net.brilliant.entity.general.TaxGroup;
import net.brilliant.exceptions.ObjectNotFoundException;
import net.brilliant.framework.service.GenericService;

public interface TaxGroupService extends GenericService<TaxGroup, Long> {

	/**
	 * Get one TaxGroup with the provided name.
	 * 
	 * @param name
	 *            The TaxGroup name
	 * @return The TaxGroup
	 * @throws ObjectNotFoundException
	 *             If no such TaxGroup exists.
	 */
	Optional<TaxGroup> getByName(String name) throws ObjectNotFoundException;
}
