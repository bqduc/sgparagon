package net.brilliant.repository.trade;

import org.springframework.stereotype.Repository;

import net.brilliant.entity.trade.Payment;
import net.brilliant.framework.repository.BaseRepository;

@Repository
public interface PaymentRepository extends BaseRepository<Payment, Long>{
}
