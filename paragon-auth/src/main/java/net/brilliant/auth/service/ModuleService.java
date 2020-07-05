package net.brilliant.auth.service;

import net.brilliant.auth.entity.Module;
import net.brilliant.exceptions.ObjectNotFoundException;
import net.brilliant.framework.service.GenericService;

public interface ModuleService extends GenericService<Module, Long> {

	/**
	 * Get one Module with the provided code.
	 * 
	 * @param name
	 *            The Module name
	 * @return The Module
	 * @throws ObjectNotFoundException
	 *             If no such Module exists.
	 */
	Module getByName(String name) throws ObjectNotFoundException;
}
