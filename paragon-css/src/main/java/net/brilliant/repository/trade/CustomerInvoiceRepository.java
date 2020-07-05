package net.brilliant.repository.trade;

import org.springframework.stereotype.Repository;

import net.brilliant.entity.emx.CustomerInvoice;
import net.brilliant.framework.repository.BaseRepository;

@Repository
public interface CustomerInvoiceRepository extends BaseRepository<CustomerInvoice, Long>{
}
