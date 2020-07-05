/**
 * 
 */
package net.brilliant.auth.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.brilliant.auth.entity.Authority;
import net.brilliant.framework.repository.NameRepository;

/**
 * @author ducbui
 *
 */
@Repository
public interface AuthorityRepository extends NameRepository <Authority, Long>{
	
	@Query("SELECT entity FROM #{#entityName} entity WHERE ("
			+ "			LOWER(entity.name) like LOWER(CONCAT('%',:keyword,'%'))"
			+ " or	LOWER(entity.info) like LOWER(CONCAT('%',:keyword,'%'))"
			+ ")"
	)
	Page<Authority> search(@Param("keyword") String keyword, Pageable pageable);
}
