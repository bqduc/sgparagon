package net.brilliant.css.service.config;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.brilliant.domain.entity.general.Language;
import net.brilliant.entity.general.GeneralCatalogue;
import net.brilliant.entity.general.LocalizedItem;
import net.brilliant.exceptions.ObjectNotFoundException;
import net.brilliant.framework.service.GenericService;

public interface ItemService extends GenericService<GeneralCatalogue, Long>{

  /**
   * Get one item with the provided code.
   * 
   * @param code The item code
   * @return The item
   * @throws ObjectNotFoundException If no such account exists.
   */
	GeneralCatalogue getObjectByCode(String code) throws ObjectNotFoundException;

  /**
   * Get one item with the provided code.
   * 
   * @param name The item name
   * @return The item
   * @throws ObjectNotFoundException If no such account exists.
   */
	GeneralCatalogue getByName(String name) throws ObjectNotFoundException;

	Page<LocalizedItem> searchLocalizedItems(String keyword, String languageCode, Pageable pageable);

	LocalizedItem getLocalizedItem(GeneralCatalogue item, Language language);

	LocalizedItem saveLocalizedItem(LocalizedItem localizedItem);
	
	List<LocalizedItem> getLocalizedItems(String subtype, Language language);
}
