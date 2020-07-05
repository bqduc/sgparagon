package net.brilliant.service.impl.trade;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.brilliant.entity.trade.Invoice;
import net.brilliant.framework.repository.BaseRepository;
import net.brilliant.framework.service.GenericServiceImpl;
import net.brilliant.repository.trade.InvoiceRepository;
import net.brilliant.service.trade.InvoiceService;

@Service
public class InvoiceServiceImpl extends GenericServiceImpl<Invoice, Long> implements InvoiceService{
	private static final long serialVersionUID = -3091073932588099354L;
	
	@Inject 
	private InvoiceRepository repository;
	
	protected BaseRepository<Invoice, Long> getRepository() {
		return this.repository;
	}
}
