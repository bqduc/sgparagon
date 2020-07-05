package net.brilliant.css.repository.config;

import org.springframework.stereotype.Repository;

import net.brilliant.domain.entity.general.Language;
import net.brilliant.framework.repository.CodeNameRepository;

@Repository("languageRepository")
public interface LanguageRepository extends CodeNameRepository<Language, Long>{
}
