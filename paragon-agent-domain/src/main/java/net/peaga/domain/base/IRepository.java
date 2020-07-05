/**
 * 
 */
package net.peaga.domain.base;

import java.io.Serializable;

/**
 * @author ducbq
 *
 */
public interface IRepository extends Serializable{
	Long getId();
	void setId(Long id);

	Boolean getActive();
	void setActive(Boolean active);

	Boolean getSystem();
	void setSystem(Boolean system);

	RepositoryId getRepositoryId();
	void setRepositoryId(RepositoryId repositoryId);
}
