package net.brilliant.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.brilliant.entity.trade.TaxRate;
import net.brilliant.framework.repository.BaseRepository;
import net.brilliant.framework.service.GenericServiceImpl;
import net.brilliant.repository.trade.TaxRateRepository;
import net.brilliant.service.trade.TaxRateService;

@Service
public class TaxRateServiceImpl extends GenericServiceImpl<TaxRate, Long> implements TaxRateService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5003151117371926438L;

	@Inject 
	private TaxRateRepository repository;
	
	protected BaseRepository<TaxRate, Long> getRepository() {
		return this.repository;
	}
}
