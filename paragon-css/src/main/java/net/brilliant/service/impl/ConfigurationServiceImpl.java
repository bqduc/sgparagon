package net.brilliant.service.impl;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.brilliant.css.repository.config.ConfigurationRepository;
import net.brilliant.css.service.config.ConfigurationService;
import net.brilliant.css.specification.ConfigurationRepoSpecification;
import net.brilliant.entity.config.Configuration;
import net.brilliant.exceptions.AppException;
import net.brilliant.exceptions.ObjectNotFoundException;
import net.brilliant.framework.model.SearchParameter;
import net.brilliant.framework.repository.BaseRepository;
import net.brilliant.framework.service.GenericServiceImpl;

@Service
public class ConfigurationServiceImpl extends GenericServiceImpl<Configuration, Long> implements ConfigurationService{
	private static final long serialVersionUID = -1435351574637430464L;

	@Inject 
	private ConfigurationRepository repository;
	
	protected BaseRepository<Configuration, Long> getRepository() {
		return this.repository;
	}

	@Override
	public Optional<Configuration> getByName(String name) throws ObjectNotFoundException {
		return repository.findByName(name);
	}

	@Override
	protected Page<Configuration> performSearch(String keyword, Pageable pageable) {
		return repository.search(keyword, pageable);
	}

	@Override
	public Page<Configuration> getObjects(SearchParameter searchParameter) {
		return this.repository.findAll(ConfigurationRepoSpecification.buildSpecification(searchParameter), searchParameter.getPageable());
	}

	@Override
	public List<Configuration> getByGroup(String group) {
		return this.repository.findByGroup(group);
	}

	@Override
	protected Optional<Configuration> fetchBusinessObject(Object key) throws AppException {
		return super.getBizObject("findByName", key);
	}

	@Override
	public boolean isExistsByGroup(String group) {
		return this.repository.existsByGroup(group);
	}

	@Override
	public boolean isExistsByName(String name) {
		return this.repository.existsByName(name);
	}
}
