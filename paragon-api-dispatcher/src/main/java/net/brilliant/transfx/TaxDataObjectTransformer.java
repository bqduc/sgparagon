/**
 * 
 */
package net.brilliant.transfx;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Component;

import net.brilliant.entity.trade.Tax;
import net.brilliant.exceptions.AppException;
import net.brilliant.framework.entity.RepoEntity;
import net.brilliant.service.trade.TaxGroupService;
import net.brilliant.service.trade.TaxService;
import net.peaga.domain.base.Repository;
import net.peaga.domain.trade.TaxProxy;

/**
 * @author ducbq
 *
 */
@Named
@Component
public class TaxDataObjectTransformer extends DataTransformerBase implements DataTransformer {
	@Inject 
	private DataTransformer simpleDataObjectTransformer;

	@Inject 
	private TaxGroupService taxGroupService;

	@Inject 
	private TaxService businessService;

	protected RepoEntity transformToBusinessObject(Repository proxyObject, RepoEntity targetBusinessObject, String[] excludedAttributes)  throws AppException {
		TaxProxy taxProxy = null;
		Tax taxObject = null;
		try {
			this.simpleDataObjectTransformer.transformToBusiness(proxyObject, targetBusinessObject, excludedAttributes);
			taxProxy = (TaxProxy)proxyObject;
			taxObject = (Tax)targetBusinessObject;
			if (taxProxy.getGroup() != null) {
				taxObject.setGroup(taxGroupService.getObject(taxProxy.getGroup().getId()));
			}

			if (null != taxProxy.getParent()) {
				taxObject.setParent(this.businessService.getObject(taxProxy.getParent().getId()));
			}
		} catch (Exception e) {
			throw new AppException(e);
		}
		return targetBusinessObject;
	}

	@Override
	protected RepoEntity doTransformToBusiness(Repository proxyObject, RepoEntity targetBusinessObject) throws AppException {
		return transformToBusinessObject(proxyObject, targetBusinessObject, new String[] {});
	}

	@Override
	protected RepoEntity doTransformToBusiness(Repository proxyObject, RepoEntity targetBusinessObject, String[] excludedAttributes) throws AppException {
		return transformToBusinessObject(proxyObject, targetBusinessObject, excludedAttributes);
	}

	@Override
	protected Repository doTransformToProxy(RepoEntity businessObject, Repository targetProxyObject) throws AppException {
		return this.simpleDataObjectTransformer.transformToProxy(businessObject, targetProxyObject);
	}
}
