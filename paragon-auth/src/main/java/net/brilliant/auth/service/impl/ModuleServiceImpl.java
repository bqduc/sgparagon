package net.brilliant.auth.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.brilliant.auth.entity.Module;
import net.brilliant.auth.repository.ModuleRepository;
import net.brilliant.auth.service.ModuleService;
import net.brilliant.exceptions.ObjectNotFoundException;
import net.brilliant.framework.repository.BaseRepository;
import net.brilliant.framework.service.GenericServiceImpl;


@Service
public class ModuleServiceImpl extends GenericServiceImpl<Module, Long> implements ModuleService{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7409137083581193634L;

	@Inject 
	private ModuleRepository repository;
	
	protected BaseRepository<Module, Long> getRepository() {
		return this.repository;
	}

	@Override
	public Module getByName(String name) throws ObjectNotFoundException {
		return (Module)super.getOptionalObject(repository.findByName(name));
	}
}
