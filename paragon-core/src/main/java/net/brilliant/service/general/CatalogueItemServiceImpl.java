package net.brilliant.service.general;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.brilliant.domain.entity.general.CatalogueItem;
import net.brilliant.exceptions.ObjectNotFoundException;
import net.brilliant.framework.repository.BaseRepository;
import net.brilliant.framework.service.GenericServiceImpl;
import net.brilliant.repository.CatalogueItemRepository;


@Service
public class CatalogueItemServiceImpl extends GenericServiceImpl<CatalogueItem, Long> implements CatalogueItemService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4566594774661053895L;

	@Inject 
	private CatalogueItemRepository repository;
	
	protected BaseRepository<CatalogueItem, Long> getRepository() {
		return this.repository;
	}

	@Override
	public CatalogueItem getByName(String name) throws ObjectNotFoundException {
		return super.getOptional(this.repository.findByName(name));
	}
}
