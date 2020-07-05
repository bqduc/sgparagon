package net.brilliant.css.repository.stock;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.brilliant.entity.stock.InventoryCore;
import net.brilliant.entity.stock.InventoryPrice;
import net.brilliant.framework.repository.BaseRepository;

@Repository
public interface InventoryPriceRepository extends BaseRepository<InventoryPrice, Long> {
	Long countByOwner(InventoryCore inventoryCore);
	List<InventoryPrice> findByOwner(InventoryCore inventoryCore);
}
