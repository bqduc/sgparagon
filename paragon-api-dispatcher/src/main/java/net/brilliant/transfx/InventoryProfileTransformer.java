/**
 * 
 */
package net.brilliant.transfx;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import net.brilliant.css.service.stock.InventoryService;
import net.brilliant.entity.stock.InventoryCore;
import net.brilliant.exceptions.AppException;
import net.brilliant.framework.entity.RepoEntity;
import net.nep.facade.ProductProfile;
import net.peaga.domain.base.Repository;
import net.peaga.domain.stock.InventoryItemProxy;

/**
 * @author ducbq
 *
 */
@Component
public class InventoryProfileTransformer implements DataTransformer {
	@Inject
	private InventoryService businessService;

	public ProductProfile marshall(InventoryItemProxy inventoryItemProxy) {
		InventoryCore inventoryCore = this.businessService.getObject(inventoryItemProxy.getId());
		if (null==inventoryCore) {
			inventoryCore = InventoryCore.builder().build();
		}
		return null;
	}

	public InventoryItemProxy unmarshall(ProductProfile productProfile) {
		InventoryItemProxy inventoryItemProxy = InventoryItemProxy.builder()
				.code(productProfile.getCore().getCode())
				.barcode(productProfile.getCore().getBarcode())
				.name(productProfile.getCore().getName())
				.labelName(productProfile.getCore().getLabelName())
				.translatedName(productProfile.getCore().getTranslatedName())
				.build();

		if (null != productProfile.getInventoryImages() && productProfile.getInventoryImages().size() > 0) {
			inventoryItemProxy.setImageData(productProfile.getInventoryImages().get(0).getImageBuffer());
		}

		return inventoryItemProxy;
	}

	@Override
	public RepoEntity transformToBusiness(final Repository proxyObject, RepoEntity targetBusinessObject) throws AppException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Repository transformToProxy(final RepoEntity businessObject, Repository targetProxyObject) throws AppException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RepoEntity transformToBusiness(Repository proxyObject, RepoEntity targetBusinessObject, String[] excludedAttributes) throws AppException {
		// TODO Auto-generated method stub
		return null;
	}
}
