package net.brilliant.repository.trade;

import org.springframework.stereotype.Repository;

import net.brilliant.entity.trade.ShipmentNote;
import net.brilliant.framework.repository.CodeSerialRepository;

@Repository
public interface ShipmentNoteRepository extends CodeSerialRepository<ShipmentNote, Long>{
}
