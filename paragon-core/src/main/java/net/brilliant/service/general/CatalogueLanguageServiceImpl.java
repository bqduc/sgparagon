package net.brilliant.service.general;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.brilliant.domain.entity.general.CatalogueItem;
import net.brilliant.domain.entity.general.CatalogueLanguage;
import net.brilliant.domain.entity.general.Language;
import net.brilliant.exceptions.ObjectNotFoundException;
import net.brilliant.framework.repository.BaseRepository;
import net.brilliant.framework.service.GenericServiceImpl;
import net.brilliant.repository.CatalogueLanguageRepository;


@Service
public class CatalogueLanguageServiceImpl extends GenericServiceImpl<CatalogueLanguage, Long> implements CatalogueLanguageService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6204618256045562145L;

	@Inject 
	private CatalogueLanguageRepository repository;
	
	protected BaseRepository<CatalogueLanguage, Long> getRepository() {
		return this.repository;
	}

	@Override
	public List<CatalogueLanguage> getByLanguage(Language language) throws ObjectNotFoundException {
		return this.repository.findByLanguage(language);
	}

	@Override
	public CatalogueLanguage getByCatalogueAndLanguage(CatalogueItem catalogue, Language language) throws ObjectNotFoundException {
		return this.repository.findByCatalogueAndLanguage(catalogue, language);
	}
}