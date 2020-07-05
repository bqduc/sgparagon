/**
 * 
 */
package net.brilliant.framework.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.brilliant.framework.entity.RepoEntity;
import net.brilliant.framework.service.ServiceImpl;

/**
 * @author ducbq
 *
 */

public abstract class BaseDAO<EntityType extends RepoEntity, Key extends Serializable> extends ServiceImpl<EntityType, Key> {
	private static final long serialVersionUID = -3317395762045169767L;

	@PersistenceContext /* (unitName = GlobalConstants.APPLICATION_PERSISTENCE_UNIT) */
	protected EntityManager em;

	@Override
	protected BaseRepository<EntityType, Key> getRepository() {
		return null;
	}
}
