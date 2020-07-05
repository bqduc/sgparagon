package net.brilliant.framework.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.brilliant.exceptions.AppException;
import net.brilliant.exceptions.ExecutionContextException;
import net.brilliant.framework.entity.RepoEntity;
import net.brilliant.framework.model.SearchParameter;
import net.brilliant.model.ExecutionContext;

public interface GenericService<T extends RepoEntity, K extends Serializable> extends IService<T, K> {
	T save(T entity);
	T saveOrUpdate(T entity);
	List<T> saveObjects(List<T> objects);

	void remove(K id);
	void remove(T entity);
	void removeAll();

	boolean exists(String countByProperty, Object value);

	Long count();
	Long count(String countByProperty, Object value);

	Long count(String countMethodName, Map<?, ?> parameters);

	String nextSerial(String prefix) throws AppException;

	Optional<T> getBusinessObject(Object key) throws AppException;
	List<T> getObjects();

	List<T> getVisibleObjects();
	/**
	 * Get objects with the provided search parameters.
	 * 
	 * @param searchParameter
	 *            The search parameter
	 * @return The pageable objects
	 */
	Page<T> getObjects(SearchParameter searchParameter);

	Page<T> getObjects(Integer pageNumber);
	Page<T> getObjects(Integer pageNumber, Integer size);
	Page<T> searchObjects(String keyword, Pageable pageable);
	Page<T> search(Map<String, Object> parameters);
	//Page<T> search(String keyword);
	Page<T> search(String keyword, Pageable pageable);

	List<T> imports(Map<Object, Object> parameters);
	List<T> search(String keyword);
	ExecutionContext load(ExecutionContext executionContext) throws ExecutionContextException;
}