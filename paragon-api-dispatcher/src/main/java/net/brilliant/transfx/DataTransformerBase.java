/**
 * 
 */
package net.brilliant.transfx;

import net.brilliant.exceptions.AppException;
import net.brilliant.framework.entity.RepoEntity;
import net.peaga.domain.base.Repository;

/**
 * @author ducbq
 *
 */
public abstract class DataTransformerBase {
	protected RepoEntity doTransformToBusiness(final Repository proxyObject, RepoEntity targetBusinessObject) throws AppException {
		return targetBusinessObject;
	}

	protected RepoEntity doTransformToBusiness(final Repository proxyObject, RepoEntity targetBusinessObject, String[] excludedAttributes) throws AppException {
		return targetBusinessObject;
	}

	protected Repository doTransformToProxy(final RepoEntity businessObject, Repository targetProxyObject) throws AppException {
		return targetProxyObject;
	}

	public final RepoEntity transformToBusiness(final Repository proxyObject, RepoEntity targetBusinessObject) throws AppException {
		return doTransformToBusiness(proxyObject, targetBusinessObject);
	}

	public final RepoEntity transformToBusiness(final Repository proxyObject, RepoEntity targetBusinessObject, String[] excludedAttributes) throws AppException {
		return doTransformToBusiness(proxyObject, targetBusinessObject, excludedAttributes);
	}

	public final Repository transformToProxy(final RepoEntity businessObject, Repository targetProxyObject) throws AppException {
		return doTransformToProxy(businessObject, targetProxyObject);
	}
}
