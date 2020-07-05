/**
 * 
 */
package net.brilliant.auth.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.brilliant.auth.entity.UserAccountPrivilege;
import net.brilliant.auth.entity.UserAccountProfile;
import net.brilliant.framework.repository.BaseRepository;

/**
 * @author bqduc
 *
 */
@Repository
public interface UserAccountPrivilegeRepository extends BaseRepository<UserAccountPrivilege, Long> {
	List<UserAccountPrivilege> findByUserAccount(UserAccountProfile userAccount);
}
