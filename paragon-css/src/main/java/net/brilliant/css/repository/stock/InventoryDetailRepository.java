package net.brilliant.css.repository.stock;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.brilliant.entity.stock.InventoryCore;
import net.brilliant.entity.stock.InventoryDetail;
import net.brilliant.framework.repository.BaseRepository;

@Repository
public interface InventoryDetailRepository extends BaseRepository<InventoryDetail, Long> {
	Long countByOwner(InventoryCore inventoryCore);
	List<InventoryDetail> findByOwner(InventoryCore inventoryCore);
}
