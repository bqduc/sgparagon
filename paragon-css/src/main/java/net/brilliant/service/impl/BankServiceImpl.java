package net.brilliant.service.impl;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.brilliant.entity.trade.Bank;
import net.brilliant.exceptions.AppException;
import net.brilliant.exceptions.ObjectNotFoundException;
import net.brilliant.framework.repository.BaseRepository;
import net.brilliant.framework.service.GenericServiceImpl;
import net.brilliant.repository.trade.BankRepository;
import net.brilliant.service.trade.BankService;

@Service
public class BankServiceImpl extends GenericServiceImpl<Bank, Long> implements BankService{
	private static final long serialVersionUID = -3460325091527495246L;

	@Inject 
	private BankRepository repository;
	
	protected BaseRepository<Bank, Long> getRepository() {
		return this.repository;
	}

	@Override
	public Optional<Bank> getByName(String name) throws ObjectNotFoundException {
		return repository.findByName(name);
	}

	@Override
	public Optional<Bank> getByCode(String code) throws ObjectNotFoundException {
		return repository.findByCode(code);
	}

	@Override
	protected Page<Bank> performSearch(String keyword, Pageable pageable) {
		return repository.find(keyword, pageable);
	}

	@Override
	protected Optional<Bank> fetchBusinessObject(Object key) throws AppException {
		return super.getBizObject("findByName", key);
	}
}
