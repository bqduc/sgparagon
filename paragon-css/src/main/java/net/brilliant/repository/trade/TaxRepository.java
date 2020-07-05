package net.brilliant.repository.trade;

import org.springframework.stereotype.Repository;

import net.brilliant.entity.trade.Tax;
import net.brilliant.framework.repository.CodeNameRepository;

@Repository
public interface TaxRepository extends CodeNameRepository<Tax, Long>{
}
