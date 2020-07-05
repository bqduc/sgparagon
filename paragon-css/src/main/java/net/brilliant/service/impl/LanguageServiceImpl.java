package net.brilliant.service.impl;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.brilliant.css.repository.config.LanguageRepository;
import net.brilliant.css.service.config.LanguageService;
import net.brilliant.domain.entity.general.Language;
import net.brilliant.framework.repository.BaseRepository;
import net.brilliant.framework.service.GenericServiceImpl;

@Service
public class LanguageServiceImpl extends GenericServiceImpl<Language, Long> implements LanguageService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7579757413128840936L;

	@Inject
	private LanguageRepository repository;

	@Override
	protected BaseRepository<Language, Long> getRepository() {
		return this.repository;
	}

	@Override
	protected Page<Language> performSearch(String keyword, Pageable pageable) {
		return this.repository.find(keyword, pageable);
	}

	@Override
	public Language getByName(String name) {
		return super.getOptional(this.repository.findByName(name));
	}
}
