/**
 * 
 */
package net.brilliant.auth.repository;

import org.springframework.stereotype.Repository;

import net.brilliant.auth.entity.Permission;
import net.brilliant.framework.repository.BaseRepository;

/**
 * @author bqduc
 *
 */
@Repository
public interface PermissionRepository extends BaseRepository<Permission, Long> {
}
