package net.brilliant.api;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.brilliant.common.BeanUtility;
import net.brilliant.common.CommonConstants;
import net.brilliant.common.CommonUtility;
import net.brilliant.common.ListUtility;
import net.brilliant.css.service.org.BusinessUnitService;
import net.brilliant.domain.model.SearchCondition;
import net.brilliant.entity.general.BusinessUnit;
import net.brilliant.exceptions.AppException;
import net.brilliant.framework.controller.RestCoreController;
import net.brilliant.framework.entity.RepoEntity;
import net.brilliant.framework.service.IService;
import net.brilliant.transfx.DataTransformer;
import net.peaga.domain.general.BusinessUnitProxy;

/**
 * @author ducbq
 */
@RestController
@Controller
@RequestMapping(value = CommonConstants.REST_API + "businessUnit")
public class BusinessUnitRestDispatcher extends RestCoreController<BusinessUnitProxy, Long> {
	private static final long serialVersionUID = -8578417652190400110L;

	@Inject 
	private BusinessUnitService businessService;

	@Inject 
	private DataTransformer simpleDataObjectTransformer;

	@Override
	protected BusinessUnitProxy doFetchBusinessObject(Long id) {
		BusinessUnit fetchedBizObject = null;
		BusinessUnitProxy proxyObject = new BusinessUnitProxy();
		try {
			fetchedBizObject = this.businessService.getObject(id);
			if (CommonUtility.isNotEmpty(fetchedBizObject)) {
				this.simpleDataObjectTransformer.transformToProxy(fetchedBizObject, proxyObject);
			}
		} catch (AppException e) {
			log.error(e);
		}
		return proxyObject;
	}

	@Override
	protected BusinessUnitProxy doCreateBusinessObject(BusinessUnitProxy proxyObject) {
		BusinessUnit newBizObject = new BusinessUnit();
		BusinessUnit parent = null;
		try {
			this.simpleDataObjectTransformer.transformToBusiness(proxyObject, newBizObject);
			if (proxyObject.getParent() != null) {
				parent = this.businessService.getObject(proxyObject.getParent().getId());
				newBizObject.setParent(parent);
			}
			this.businessService.saveOrUpdate(newBizObject);
			proxyObject.setId(newBizObject.getId());
			System.out.println("Done");
		} catch (Exception e) {
			log.error(e);
		}
		return proxyObject;
	}

	@Override
	protected BusinessUnitProxy doUpdateBusinessObject(BusinessUnitProxy proxyObject) {
		BusinessUnit bizObject = this.businessService.getObject(proxyObject.getId());
		BeanUtility.getInstance().copyBeanData(proxyObject, bizObject, new String[] {"id", "parent"});
		//transformParents(bizObject, proxyObject);
		if (null != proxyObject.getParent()) {
			bizObject.setParent(this.businessService.getObject(proxyObject.getParent().getId()));
		}

		this.businessService.saveOrUpdate(bizObject);
		return proxyObject;
	}

	@Override
	protected IService<?, Long> getBusinessService() {
		return this.businessService;
	}

	@Override
	protected List<BusinessUnitProxy> searchBusinessObjects(SearchCondition searchCondition) {
		List<BusinessUnitProxy> list = ListUtility.createList();
		BusinessUnit fetchedBizObject = this.businessService.getObjectByCode(searchCondition.getCode());
		if (null != fetchedBizObject) {
			BusinessUnitProxy taxGroupProxy = BusinessUnitProxy.builder().build();
			try {
				this.simpleDataObjectTransformer.transformToProxy(fetchedBizObject, taxGroupProxy);
			} catch (AppException e) {
				log.error(e);
			}
			list.add(taxGroupProxy);
		}
		return list;
	}

	protected RepoEntity transformParents(BusinessUnit businessObject, BusinessUnitProxy proxyObject) {
		BusinessUnit parent = null;
		while (null != businessObject && null != proxyObject && null != proxyObject.getParent()) {
			parent = this.businessService.getObject(proxyObject.getParent().getId());
			businessObject.setParent(parent);

			businessObject = businessObject.getParent();
			proxyObject = proxyObject.getParent();
		}
		return businessObject;
	}

	@Override
	protected BusinessUnitProxy createBusinessProxyObject(boolean isDummy) {
		BusinessUnitProxy fetchedObject = new BusinessUnitProxy();
		if (isDummy) {
			fetchedObject.setCode(CommonConstants.DUMMY);
			fetchedObject.setName(CommonConstants.DUMMY);
		}
		return fetchedObject;
	}
}
