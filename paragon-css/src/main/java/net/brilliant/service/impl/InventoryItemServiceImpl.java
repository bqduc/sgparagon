package net.brilliant.service.impl;

import javax.inject.Inject;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import net.brilliant.css.repository.stock.InventoryItemRepository;
import net.brilliant.css.service.stock.InventoryItemService;
import net.brilliant.css.specification.InventoryItemSpecification;
import net.brilliant.entity.stock.InventoryItem;
import net.brilliant.exceptions.ObjectNotFoundException;
import net.brilliant.framework.model.SearchParameter;
import net.brilliant.framework.repository.BaseRepository;
import net.brilliant.framework.service.GenericServiceImpl;


@Service
public class InventoryItemServiceImpl extends GenericServiceImpl<InventoryItem, Long> implements InventoryItemService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7761477574156308888L;

	@Inject 
	private InventoryItemRepository repository;
	
	protected BaseRepository<InventoryItem, Long> getRepository() {
		return this.repository;
	}

	@Override
	public InventoryItem getByBarcode(String barcode) throws ObjectNotFoundException {
		return (InventoryItem)super.getOptionalObject(repository.findByBarcode(barcode));
	}

	@Override
	protected Specification<InventoryItem> getRepoSpecification(SearchParameter searchParameter) {
		return InventoryItemSpecification.buildSpecification(searchParameter);
	}
}
