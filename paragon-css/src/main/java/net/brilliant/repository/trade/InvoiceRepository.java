package net.brilliant.repository.trade;

import org.springframework.stereotype.Repository;

import net.brilliant.entity.trade.Invoice;
import net.brilliant.framework.repository.CodeSerialRepository;

@Repository
public interface InvoiceRepository extends CodeSerialRepository<Invoice, Long>{
}
