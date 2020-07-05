package net.brilliant.service.impl;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.brilliant.entity.trade.Portfolio;
import net.brilliant.exceptions.AppException;
import net.brilliant.exceptions.ObjectNotFoundException;
import net.brilliant.framework.repository.BaseRepository;
import net.brilliant.framework.service.GenericServiceImpl;
import net.brilliant.repository.trade.PortfolioRepository;
import net.brilliant.service.trade.PortfolioService;

@Service
public class PortfolioServiceImpl extends GenericServiceImpl<Portfolio, Long> implements PortfolioService{
	private static final long serialVersionUID = -8628938623043465764L;

	@Inject 
	private PortfolioRepository repository;
	
	protected BaseRepository<Portfolio, Long> getRepository() {
		return this.repository;
	}

	@Override
	public Optional<Portfolio> getByName(String name) throws ObjectNotFoundException {
		return repository.findByName(name);
	}

	@Override
	public Optional<Portfolio> getByCode(String code) throws ObjectNotFoundException {
		return repository.findByCode(code);
	}

	@Override
	protected Page<Portfolio> performSearch(String keyword, Pageable pageable) {
		return repository.find(keyword, pageable);
	}

	@Override
	protected Optional<Portfolio> fetchBusinessObject(Object key) throws AppException {
		return super.getBizObject("findByName", key);
	}
}
