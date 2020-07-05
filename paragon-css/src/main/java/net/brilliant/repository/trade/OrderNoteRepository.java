package net.brilliant.repository.trade;

import org.springframework.stereotype.Repository;

import net.brilliant.entity.trade.OrderNote;
import net.brilliant.framework.repository.CodeNameRepository;

@Repository
public interface OrderNoteRepository extends CodeNameRepository<OrderNote, Long>{
}
