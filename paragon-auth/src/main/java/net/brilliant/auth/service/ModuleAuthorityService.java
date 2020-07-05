package net.brilliant.auth.service;

import java.util.List;

import net.brilliant.auth.entity.Authority;
import net.brilliant.auth.entity.Module;
import net.brilliant.auth.entity.ModuleAuthority;
import net.brilliant.exceptions.ObjectNotFoundException;
import net.brilliant.framework.service.GenericService;

public interface ModuleAuthorityService extends GenericService<ModuleAuthority, Long> {

	/**
	 * Get one Module with the provided code.
	 * 
	 * @param module
	 *            The Module
	 * @param authority
	 *            The Authority
	 * @return The list
	 * @throws ObjectNotFoundException
	 *             If no such Module exists.
	 */
	List<ModuleAuthority> get(Module module, Authority authority) throws ObjectNotFoundException;
}
