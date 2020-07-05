package net.brilliant.repository.trade;

import org.springframework.stereotype.Repository;

import net.brilliant.entity.trade.TaxRate;
import net.brilliant.framework.repository.BaseRepository;

@Repository
public interface TaxRateRepository extends BaseRepository<TaxRate, Long>{
}
