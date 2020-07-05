package net.brilliant.repository.trade;

import org.springframework.stereotype.Repository;

import net.brilliant.entity.trade.Account;
import net.brilliant.framework.repository.CodeNameRepository;

@Repository
public interface AccountRepository extends CodeNameRepository<Account, Long>{
}
