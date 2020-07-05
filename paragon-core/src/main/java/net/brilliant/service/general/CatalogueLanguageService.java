package net.brilliant.service.general;

import java.util.List;

import net.brilliant.domain.entity.general.CatalogueItem;
import net.brilliant.domain.entity.general.CatalogueLanguage;
import net.brilliant.domain.entity.general.Language;
import net.brilliant.exceptions.ObjectNotFoundException;
import net.brilliant.framework.service.GenericService;

public interface CatalogueLanguageService extends GenericService<CatalogueLanguage, Long> {
	List<CatalogueLanguage> getByLanguage(Language language) throws ObjectNotFoundException;
	CatalogueLanguage getByCatalogueAndLanguage(CatalogueItem catalogue, Language language) throws ObjectNotFoundException;
}
