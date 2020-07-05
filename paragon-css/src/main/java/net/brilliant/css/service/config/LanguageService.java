package net.brilliant.css.service.config;

import java.util.Optional;

import net.brilliant.domain.entity.general.Language;
import net.brilliant.framework.service.GenericService;

public interface LanguageService extends GenericService<Language, Long>{
	Optional<Language> getByCode(String code);
	Language getByName(String name);
}
