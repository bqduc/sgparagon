package net.brilliant.repository.trade;

import org.springframework.stereotype.Repository;

import net.brilliant.entity.trade.Portfolio;
import net.brilliant.framework.repository.CodeNameRepository;

@Repository
public interface PortfolioRepository extends CodeNameRepository<Portfolio, Long>{
}
