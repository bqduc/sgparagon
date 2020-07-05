package net.brilliant.service.impl;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.brilliant.entity.trade.Tax;
import net.brilliant.exceptions.AppException;
import net.brilliant.exceptions.ObjectNotFoundException;
import net.brilliant.framework.repository.BaseRepository;
import net.brilliant.framework.service.GenericServiceImpl;
import net.brilliant.repository.trade.TaxRepository;
import net.brilliant.service.trade.TaxService;

@Service
public class TaxServiceImpl extends GenericServiceImpl<Tax, Long> implements TaxService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1827391253714417691L;

	@Inject 
	private TaxRepository repository;
	
	protected BaseRepository<Tax, Long> getRepository() {
		return this.repository;
	}

	@Override
	public Optional<Tax> getByName(String name) throws ObjectNotFoundException {
		return repository.findByName(name);
	}

	@Override
	public Optional<Tax> getByCode(String code) throws ObjectNotFoundException {
		return repository.findByCode(code);
	}

	@Override
	protected Page<Tax> performSearch(String keyword, Pageable pageable) {
		return repository.find(keyword, pageable);
	}

	@Override
	protected Optional<Tax> fetchBusinessObject(Object key) throws AppException {
		return super.getBizObject("findByName", key);
	}
}
