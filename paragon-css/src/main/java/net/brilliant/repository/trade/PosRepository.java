package net.brilliant.repository.trade;

import org.springframework.stereotype.Repository;

import net.brilliant.entity.trade.Pos;
import net.brilliant.framework.repository.CodeNameRepository;

@Repository
public interface PosRepository extends CodeNameRepository<Pos, Long>{
}
