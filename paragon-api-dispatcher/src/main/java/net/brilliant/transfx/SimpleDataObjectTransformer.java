/**
 * 
 */
package net.brilliant.transfx;

import java.lang.reflect.InvocationTargetException;

import javax.inject.Named;

import org.springframework.stereotype.Component;

import net.brilliant.common.BeanUtility;
import net.brilliant.exceptions.AppException;
import net.brilliant.framework.entity.RepoEntity;
import net.peaga.domain.base.Repository;

/**
 * @author ducbq
 *
 */
@Named
@Component
public class SimpleDataObjectTransformer implements DataTransformer {
	@Override
	public RepoEntity transformToBusiness(final Repository proxyObject, RepoEntity targetBusinessObject) throws AppException {
		try {
			BeanUtility.copyBean(proxyObject, targetBusinessObject);
		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
			throw new AppException(e);
		}
		return targetBusinessObject;
	}

	@Override
	public Repository transformToProxy(final RepoEntity businessObject, Repository targetProxyObject) throws AppException {
		try {
			BeanUtility.copyBean(businessObject, targetProxyObject);
		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
			throw new AppException(e);
		}
		return targetProxyObject;
	}

	@Override
	public RepoEntity transformToBusiness(Repository proxyObject, RepoEntity targetBusinessObject, String[] excludedAttributes) throws AppException {
		return (RepoEntity)BeanUtility.getInstance().copyBeanData(proxyObject, targetBusinessObject, excludedAttributes);
	}
}
