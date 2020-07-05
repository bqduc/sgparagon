package net.brilliant.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.brilliant.css.repository.stock.InventoryCoreRepository;
import net.brilliant.css.repository.stock.InventoryDetailRepository;
import net.brilliant.css.repository.stock.InventoryImageRepository;
import net.brilliant.css.service.stock.InventoryService;
import net.brilliant.domain.entity.Attachment;
import net.brilliant.entity.stock.InventoryCore;
import net.brilliant.entity.stock.InventoryDetail;
import net.brilliant.entity.stock.InventoryImage;
import net.brilliant.framework.repository.BaseRepository;
import net.brilliant.framework.service.GenericServiceImpl;
import net.nep.facade.ProductProfile;


@Service
public class InventoryServiceImpl extends GenericServiceImpl<InventoryCore, Long> implements InventoryService {
	private static final long serialVersionUID = 7785962811434327239L;

	@Inject 
	private InventoryCoreRepository repository;

	@Inject 
	private InventoryImageRepository inventoryImageRepository;

	@Inject 
	private InventoryDetailRepository inventoryDetailRepository;

	protected BaseRepository<InventoryCore, Long> getRepository() {
		return this.repository;
	}

	@Override
	public ProductProfile getProfile(Long objectId) {
		InventoryCore productCore = super.getById(objectId);

		List<InventoryImage> inventoryImages = inventoryImageRepository.findByOwner(productCore);
		//Finally, create profile and associate dependencies
		ProductProfile profileFacade = ProductProfile.builder()
				.core(productCore)
				.inventoryImages(inventoryImages)
		.build();

		return profileFacade;
	}

	@Override
	public InventoryImage saveInventoryImage(InventoryImage inventoryImage) {
		return inventoryImageRepository.saveAndFlush(inventoryImage);
	}

	@Override
	public InventoryDetail saveInventoryImage(InventoryDetail inventoryDetail) {
		return this.inventoryDetailRepository.saveAndFlush(inventoryDetail);
	}

	@Override
	public ProductProfile saveProfile(ProductProfile productProfile) {
		this.repository.saveAndFlush(productProfile.getCore());

		//Save images. Delete all currents and 
		//if (Boolean.TRUE.equals(productProfile.getChangedImages())) {
		for (Attachment attachment :productProfile.getImages()) {
			this.inventoryImageRepository.saveAndFlush(
  			InventoryImage.builder()
  			.owner(productProfile.getCore())
  			.contentType(attachment.getMimetype())
  			.imageName(attachment.getName())
  			.imageBuffer(attachment.getData())
  			.build()
			);
		}
		//}
		return productProfile;
	}

	@Override
	public List<InventoryImage> getInventoryImages(Long inventoryId) {
		InventoryCore inventory = this.getById(inventoryId);
		return inventoryImageRepository.findByOwner(inventory);
	}

	@Override
	public InventoryImage getInventoryImage(Long inventoryImageId) {
		return inventoryImageRepository.findById(inventoryImageId).orElse(null);
	}
}
