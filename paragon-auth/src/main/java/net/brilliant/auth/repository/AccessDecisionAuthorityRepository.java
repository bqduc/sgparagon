/**
 * 
 */
package net.brilliant.auth.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.brilliant.auth.entity.AccessDecisionAuthority;
import net.brilliant.auth.entity.Authority;
import net.brilliant.framework.repository.BaseRepository;

/**
 * @author bqduc
 *
 */
@Repository
public interface AccessDecisionAuthorityRepository extends BaseRepository<AccessDecisionAuthority, Long> {
	List<AccessDecisionAuthority> findByAuthority(Authority authority);

	boolean existsByAuthority(Authority authority);
}
