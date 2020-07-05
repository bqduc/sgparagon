package net.brilliant.css.repository.config;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import net.brilliant.domain.entity.general.Language;
import net.brilliant.entity.general.GeneralCatalogue;
import net.brilliant.entity.general.LocalizedItem;
import net.brilliant.framework.repository.BaseRepository;

@Repository
public interface LocalizedItemRepository extends BaseRepository<LocalizedItem, Long>{

	@Query("SELECT entity FROM #{#entityName} entity WHERE ("
			+ " entity.item = :item and entity.language = :language"
			+ ")"
	)
	public LocalizedItem findByLocalizedItem(Language language, GeneralCatalogue item);
}
