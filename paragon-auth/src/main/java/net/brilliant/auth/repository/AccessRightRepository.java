/**
 * 
 */
package net.brilliant.auth.repository;

import org.springframework.stereotype.Repository;

import net.brilliant.auth.entity.AccessRight;
import net.brilliant.framework.repository.BaseRepository;

/**
 * @author bqduc
 *
 */
@Repository
public interface AccessRightRepository extends BaseRepository<AccessRight, Long> {
	AccessRight findByName(String name);
}
