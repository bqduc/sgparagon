package net.brilliant.service.impl;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.brilliant.css.repository.contact.ContactRepository;
import net.brilliant.css.service.contact.ContactService;
import net.brilliant.css.specification.ContactSpecification;
import net.brilliant.entity.contact.CTAContact;
import net.brilliant.exceptions.ExecutionContextException;
import net.brilliant.exceptions.ObjectNotFoundException;
import net.brilliant.framework.model.SearchParameter;
import net.brilliant.framework.repository.BaseRepository;
import net.brilliant.framework.service.GenericServiceImpl;
import net.brilliant.model.ExecutionContext;


@Service
public class ContactServiceImpl extends GenericServiceImpl<CTAContact, Long> implements ContactService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7761477574156308888L;

	@Inject 
	private ContactRepository repository;
	
	protected BaseRepository<CTAContact, Long> getRepository() {
		return this.repository;
	}

	@Override
	public CTAContact getObjectByCode(String code) throws ObjectNotFoundException {
		return (CTAContact)super.getOptionalObject(repository.findByCode(code));
	}

	@Override
	protected Page<CTAContact> performSearch(String keyword, Pageable pageable) {
		return repository.search(keyword, pageable);
	}

	@Override
	public Page<CTAContact> getObjects(SearchParameter searchParameter) {
		Page<CTAContact> pagedProducts = this.repository.findAll(ContactSpecification.buildSpecification(searchParameter), searchParameter.getPageable());
		//Perform additional operations here
		return pagedProducts;
	}

	@Override
	public ExecutionContext load(ExecutionContext executionContext) throws ExecutionContextException {
		/*GlobalDataServicesRepository globalDataServicesRepository = null;
		Object projectContextData = null;
		DataInterfaceModel dataInterfaceModel = null;
		IDataContainer<String> dataContainer = null;
		try {
			if (!(executionContext.containKey(DeploymentSpecification.DEPLOYMENT_DATA_KEY) || 
					executionContext.containKey(DeploymentSpecification.DEPLOYMENT_DATA_MODEL_KEY))){
				executionContext.setExecutionStage("There is not enough deployment specification for Contact. ");
				log.info(executionContext.getExecutionStage());
				return executionContext;
			}

			globalDataServicesRepository = GlobalDataServicesRepository.builder().build();
			projectContextData = executionContext.getContextData(DeploymentSpecification.DEPLOYMENT_DATA_KEY);
			dataInterfaceModel = (DataInterfaceModel)executionContext.getContextData(DeploymentSpecification.DEPLOYMENT_DATA_MODEL_KEY);
			if (DataSourceType.CSV.equals(dataInterfaceModel.getDataSourceType())){
				dataContainer = globalDataServicesRepository.readCsvFile(
						(InputStream)projectContextData, 
						dataInterfaceModel.isProcessColumnHeaders(), 
						dataInterfaceModel.getComponentSeparator());
			} else if (DataSourceType.EXCEL.equals(dataInterfaceModel.getDataSourceType())) {
			}

			if (CommonUtility.isEmpty(dataContainer)){
				executionContext.setExecutionStage("The data container is empty. Please recheck data source. ");
				log.info(executionContext.getExecutionStage());
				return executionContext;
			}
			log.info("Start to deploy Contact data ......");
			
		} catch (Exception e) {
			throw new ExecutionContextException(e);
		}

		executionContext.setExecutionStage("The data deployment for project is done. ");
		log.info(executionContext.getExecutionStage());*/
		return executionContext;
	}
}
