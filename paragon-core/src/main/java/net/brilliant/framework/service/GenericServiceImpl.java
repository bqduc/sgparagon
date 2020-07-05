package net.brilliant.framework.service;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang.StringUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import net.brilliant.autx.SecurityServiceContextHelper;
import net.brilliant.common.BeanUtility;
import net.brilliant.common.CommonConstants;
import net.brilliant.common.CommonUtility;
import net.brilliant.common.ListUtility;
import net.brilliant.exceptions.AppException;
import net.brilliant.exceptions.CommonException;
import net.brilliant.exceptions.ExecutionContextException;
import net.brilliant.exceptions.ObjectNotFoundException;
import net.brilliant.framework.entity.RepoAuditable;
import net.brilliant.framework.entity.RepoEntity;
import net.brilliant.framework.model.SearchParameter;
import net.brilliant.framework.model.SearchSpec;
import net.brilliant.framework.predicator.BrilliancePredicator;
import net.brilliant.framework.repository.BaseRepository;
import net.brilliant.framework.repository.CodeSerialRepository;
import net.brilliant.framework.specification.DefaultSpecification;
import net.brilliant.model.ExecutionContext;


@Service
public abstract class GenericServiceImpl<ClassType extends RepoEntity, Key extends Serializable> extends BaseServiceImpl<ClassType, Key> implements GenericService<ClassType, Key>{
	private static final long serialVersionUID = 7066816485194481124L;

	@Inject 
	private SecurityServiceContextHelper securityServiceContextHelper;

	protected abstract BaseRepository<ClassType, Key> getRepository();
	//protected abstract BrillianceRepository<EntityType, Key> getRepository();

	protected BrilliancePredicator<ClassType> getRepositoryPredicator(){
		return null;
	}

  @PersistenceContext
  private EntityManager em;

  protected EntityManager getEntityManager(){
  	return this.em;
  }

  protected String getLoggedInUsername() {
  	String loggedInUsername = null;
  	Object principal = securityServiceContextHelper.getAuthenticationPrincipal();
  	if (principal instanceof UserDetails) {
  		loggedInUsername = ((UserDetails)principal).getUsername();
  	} else {
  		loggedInUsername = principal.toString();
  	}
  	return loggedInUsername;
  }
  
	protected Specification<ClassType> getRepoSpecification(SearchParameter searchParameter){
  	//return (Specification<EntityType>) DefaultBrilliancePredicator.builder().build().buildSpecification(searchParameter);
  	return null;
  }

	@Override
	public Page<ClassType> getObjects(SearchParameter searchParameter) {
		Specification<ClassType> repoSpec = getRepoSpecification(searchParameter);
		if (null==repoSpec) {
			repoSpec = DefaultSpecification.<ClassType, SearchSpec>builder().build().buildRepoSpecification(searchParameter);
		}
		return getRepository().findAll(repoSpec, searchParameter.getPageable());
	}

	/**
	 * @param 
	 * contextParams context parameters
	 * 
	 */
	protected Optional<ClassType> getBizObject(Map<?, ?> contextParams) throws ObjectNotFoundException {
		Object operationSpec = contextParams.get(CommonConstants.PARAM_OPERATION);
		Map<?, ?> operationData = (Map<?, ?>)contextParams.get(CommonConstants.PARAM_DATA);
		
		Object fetchedObject = null;
		BaseRepository<ClassType, Key> repository = this.getRepository();
		try {
			if (operationSpec instanceof String) {
				fetchedObject = BeanUtility.invokeOperation(repository, (String)operationSpec, operationData, PACKAGE_PREFIX);
			} else if (operationSpec instanceof List) {
				List<String> operationSpecs = (List<String>)operationSpec;
				for (String currentOperationSpec :operationSpecs) {
					fetchedObject = BeanUtility.invokeOperation(repository, (String)operationSpec, operationData, PACKAGE_PREFIX);
					if (null != fetchedObject) {
						break;
					}
				}
			}
		} catch (Exception e) {
			throw new ObjectNotFoundException(e);
		}
		return Optional.of((ClassType)fetchedObject);
	}

	protected Optional<ClassType> getBizObject(String defaultOperationName, Object param) throws ObjectNotFoundException {
		Map<String, Object> paramData = CommonUtility.createParameterMap("name", param);
		Map<String, Object> contextParams = CommonUtility.createParameterMap(CommonConstants.PARAM_OPERATION, defaultOperationName, CommonConstants.PARAM_DATA, paramData);

		return getBizObject(contextParams);
	}

	protected Optional<ClassType> fetchBusinessObject(Object key) throws AppException {
    throw new AppException("Not implemented yet. ");
	}

	protected Page<ClassType> getPaginatedObjects(Integer page, Integer size){
		int requestedPageIdx = page-1;
		if (requestedPageIdx < 0)
			requestedPageIdx = 0;

		PageRequest pageRequest = PageRequest.of(requestedPageIdx, size, Sort.Direction.ASC, "id");
    BaseRepository<ClassType, Key> repo = getRepository();
    if (null != repo)
    	return repo.findAll(pageRequest);

    return null;
	}

  @Override
  @Transactional(propagation = Propagation.REQUIRED)
	public void remove(Key id) {
		try {
			//getRepository().delete(id);
		} catch (EmptyResultDataAccessException e) {
			log.error("Delete object by key", e);
		}
	}

  @Override
  @Transactional(propagation = Propagation.REQUIRED)
	public void remove(ClassType entity) {
		try {
			getRepository().delete(entity);
		} catch (EmptyResultDataAccessException e) {
			log.error("Delete object. ", e);
		}
	}

  @Override
  @Transactional(propagation = Propagation.REQUIRED)
  public void removeAll() {
		try {
			getRepository().deleteAll();
		} catch (EmptyResultDataAccessException e) {
			log.error("Delete all objects. ", e);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public boolean exists(String countByProperty, Object value) {
		String invokeMethod = "existsBy" + StringUtils.capitalize(countByProperty);
		Map<?, ?> parameters = ListUtility.createMap(countByProperty, value);
		boolean isExists = false;
		try {
			isExists = existsEntity(invokeMethod, parameters);
		} catch (AppException e) {
			throw new CommonException(e);
		}
		return isExists;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Long count() {
		return getRepository().count();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Long count(String countByProperty, Object value) {
		String invokeMethod = "countBy" + StringUtils.capitalize(countByProperty);
		Map<?, ?> parameters = ListUtility.createMap(countByProperty, value);
		return countEntity(invokeMethod, parameters);
		//throw new RuntimeException("Not implemented yet");
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Long count(String countMethodName, Map<?, ?> parameters) {
		return countEntity(countMethodName, parameters);
	}

	private long countEntity(String methodName, Map<?, ?> parameters) {
		Object retData = null;
		long count = 0;
		try {
			retData = BeanUtility.invokeOperation(this.getRepository(), methodName, parameters, PACKAGE_PREFIX);
			count = (Long)retData;
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| InstantiationException e) {
			log.error(e);
		}
		return count;
	}

	private boolean existsEntity(String methodName, Map<?, ?> parameters) throws AppException {
		Object retData = null;
		boolean exists = false;
		try {
			retData = BeanUtility.invokeOperation(this.getRepository(), methodName, parameters, PACKAGE_PREFIX);
			exists = Boolean.TRUE.equals(retData);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| InstantiationException e) {
			//log.error(e);
			throw new AppException(e);
		}
		return exists;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<ClassType> getObjects() {
		List<ClassType> results = new ArrayList<>();
		getRepository().findAll().forEach(results::add);
		return results;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<ClassType> getVisibleObjects() {
		return getRepository().findVisible();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<ClassType> getObjects(Integer pageNumber) {
		return getPaginatedObjects(pageNumber, CommonConstants.DEFAULT_PAGE_SIZE);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Page<ClassType> getObjects(Integer pageNumber, Integer size) {
		return getPaginatedObjects(pageNumber, size);
	}

  @Override
  @Transactional(propagation = Propagation.REQUIRED)
  public ClassType save(ClassType entity) {
  	try {
    	ClassType mergedEntity = null;
    	BaseRepository<ClassType, Key> respository = getRepository();
    	if (null != respository){
    		respository.saveAndFlush(entity);
    	} else {
    		log.info("There is no implemented repository for " + this.getClass().getSimpleName());
      	if (null == entity.getId()){
      		this.em.persist(entity);
      	}else{
      		mergedEntity = this.em.merge(entity);
      		this.em.refresh(mergedEntity);
      	}
      	this.em.flush();
    		log.info("Use the persistence context entity manager object instead of repository. ");
    	}
		} catch (Exception e) {
			e.printStackTrace();
		}
  	return entity;
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED)
  public ClassType saveOrUpdate(ClassType entity) {
  	return this.save(entity);
  }

	public List<ClassType> imports(Map<Object, Object> parameters){
		return null;
	}

	protected Page<ClassType> doGetObjects(SearchParameter searchParameter) {
		BaseRepository<ClassType, Key> repository = getRepository();
		BrilliancePredicator<ClassType> predicator = this.getRepositoryPredicator();
		Page<ClassType> pagedObjects = null;
		if (null != predicator){
			pagedObjects = repository.findAll(predicator.buildSpecification(searchParameter), searchParameter.getPageable());
		}else{
			//pagedObjects = ListUtility.createPageable(repository.findAll(), searchParameter.getPageable());
		}
		return pagedObjects;
	}

	/*public Page<ClassType> getObjects(SearchParameter searchParameter) {
		//Page<EntityType> pagedEntities = doGetObjects(searchParameter);
		Page<ClassType> pagedEntities = performGetObjects(searchParameter);
		//Perform additional operations here
		return pagedEntities;
	}*/

	public ExecutionContext load(ExecutionContext executionContext) throws ExecutionContextException {
		return executionContext;
	}

	/*protected Page<ClassType> performGetObjects(SearchParameter searchParameter) {
		return getRepository().findAll(
				DefaultSpecification.<ClassType, SearchSpec>builder().build().buildRepoSpecification(searchParameter),
				searchParameter.getPageable());
	}*/

	public Optional<ClassType> getBusinessObject(Object key) throws AppException {
		Optional<ClassType> fetchedBizObject = this.fetchBusinessObject(key);
		if (!fetchedBizObject.isPresent())
			return Optional.empty();

		if (fetchedBizObject.get() instanceof RepoAuditable && 
				(!Boolean.TRUE.equals(((RepoAuditable)fetchedBizObject.get()).getVisible())||!Boolean.TRUE.equals(((RepoAuditable)fetchedBizObject.get()).getSystem()))) {
			log.error("The business object with key: [" + key + "] not activated or visible yet. ");
			return Optional.empty();
		}

		return fetchedBizObject;
	}

	public String nextSerial(String prefix) throws AppException {
		throw new AppException("Not implemented yet!");
	}

	public Optional<ClassType> getByCode(String code) throws ObjectNotFoundException {
		return ((CodeSerialRepository<ClassType, Key>)getRepository()).findByCode(code);
	}

	public Optional<ClassType> getBySerial(String serial) throws ObjectNotFoundException {
		return ((CodeSerialRepository<ClassType, Key>)getRepository()).findBySerial(serial);
	}
}