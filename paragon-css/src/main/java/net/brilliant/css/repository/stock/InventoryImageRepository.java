package net.brilliant.css.repository.stock;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.brilliant.entity.stock.InventoryCore;
import net.brilliant.entity.stock.InventoryImage;
import net.brilliant.framework.repository.BaseRepository;

@Repository
public interface InventoryImageRepository extends BaseRepository<InventoryImage, Long> {
	Long countByOwner(InventoryCore inventoryCore);
	List<InventoryImage> findByOwner(InventoryCore inventoryCore);
}
