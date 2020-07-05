package net.brilliant.css.service.stock;

import java.util.List;

import net.brilliant.entity.stock.InventoryCore;
import net.brilliant.entity.stock.InventoryDetail;
import net.brilliant.entity.stock.InventoryImage;
import net.brilliant.framework.service.GenericService;
import net.nep.facade.ProductProfile;

public interface InventoryService extends GenericService<InventoryCore, Long> {
	ProductProfile getProfile(Long objectId);

	InventoryImage saveInventoryImage(InventoryImage inventoryImage);
	List<InventoryImage> getInventoryImages(Long inventoryId);

	InventoryImage getInventoryImage(Long inventoryImageId);
	
	InventoryDetail saveInventoryImage(InventoryDetail inventoryDetail);

	ProductProfile saveProfile(ProductProfile productProfile);
}
