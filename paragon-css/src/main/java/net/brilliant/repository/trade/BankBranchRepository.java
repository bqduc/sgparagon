package net.brilliant.repository.trade;

import org.springframework.stereotype.Repository;

import net.brilliant.entity.trade.BankBranch;
import net.brilliant.framework.repository.CodeNameRepository;

@Repository
public interface BankBranchRepository extends CodeNameRepository<BankBranch, Long>{
}
