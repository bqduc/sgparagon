package net.brilliant.auth.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.brilliant.auth.entity.Authority;
import net.brilliant.auth.entity.Module;
import net.brilliant.auth.entity.ModuleAuthority;
import net.brilliant.auth.repository.ModuleAuthorityRepository;
import net.brilliant.auth.service.ModuleAuthorityService;
import net.brilliant.exceptions.ObjectNotFoundException;
import net.brilliant.framework.repository.BaseRepository;
import net.brilliant.framework.service.GenericServiceImpl;


@Service
public class ModuleAuthorityServiceImpl extends GenericServiceImpl<ModuleAuthority, Long> implements ModuleAuthorityService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3269698913225344087L;

	@Override
	public List<ModuleAuthority> get(Module module, Authority authority) throws ObjectNotFoundException {
		return this.repository.findByModuleAndAuthority(module, authority);
	}

	@Inject 
	private ModuleAuthorityRepository repository;
	
	protected BaseRepository<ModuleAuthority, Long> getRepository() {
		return this.repository;
	}
}
