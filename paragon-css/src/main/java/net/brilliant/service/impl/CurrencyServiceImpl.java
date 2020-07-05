package net.brilliant.service.impl;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.brilliant.css.repository.general.CurrencyRepository;
import net.brilliant.css.service.general.CurrencyService;
import net.brilliant.css.service.system.SequenceManager;
import net.brilliant.css.specification.CurrencySpecification;
import net.brilliant.entity.general.Currency;
import net.brilliant.exceptions.AppException;
import net.brilliant.exceptions.ObjectNotFoundException;
import net.brilliant.framework.model.SearchParameter;
import net.brilliant.framework.repository.BaseRepository;
import net.brilliant.framework.service.GenericServiceImpl;
import net.brilliant.global.GlobalConstants;

@Service
public class CurrencyServiceImpl extends GenericServiceImpl<Currency, Long> implements CurrencyService{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3677680060876281817L;

	@Inject 
	private CurrencyRepository repository;

	@Inject
	private SequenceManager sequenceManager;

	protected BaseRepository<Currency, Long> getRepository() {
		return this.repository;
	}

	@Override
	public Optional<Currency> getByCode(String alphabeticCode) throws ObjectNotFoundException {
		return repository.findByCode(alphabeticCode);
	}

	@Override
	protected Page<Currency> performSearch(String keyword, Pageable pageable) {
		return repository.search(keyword, pageable);
	}

	@Override
	public Page<Currency> getObjects(SearchParameter searchParameter) {
		return this.repository.findAll(CurrencySpecification.buildSpecification(searchParameter), searchParameter.getPageable());
	}

	@Override
	public String nextSerial(String prefix) throws AppException {
		String newSerialNo = this.sequenceManager.getNewNumber(prefix, Integer.valueOf(GlobalConstants.SIZE_CODE));
		newSerialNo = prefix + newSerialNo.substring(prefix.length());
		return newSerialNo;
	}
}
