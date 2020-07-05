package net.brilliant.repository.trade;

import org.springframework.stereotype.Repository;

import net.brilliant.entity.trade.Bank;
import net.brilliant.framework.repository.CodeNameRepository;

@Repository
public interface BankRepository extends CodeNameRepository<Bank, Long>{
}
