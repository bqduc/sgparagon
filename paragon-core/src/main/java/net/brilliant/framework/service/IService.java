package net.brilliant.framework.service;

import java.io.Serializable;
import java.util.List;

import net.brilliant.framework.entity.RepoEntity;

public interface IService<T extends RepoEntity, K extends Serializable> extends Serializable {
  /**
   * Get object with the provided key.
   * 
   * @param id The object key
   * @return The Object
   */
	T getObject(K id);

  /**
   * Search objects with the provided search parameter.
   * 
   * @param searchParam The search key or parameter
   * @return The list of found objects
   */
	List<T> search(Object searchParam);
}