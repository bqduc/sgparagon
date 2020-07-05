/**
 * 
 */
package net.brilliant.auth.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.brilliant.auth.entity.SecurityPolicy;
import net.brilliant.framework.repository.NameRepository;

/**
 * @author bqduc
 *
 */
@Repository
public interface SecurityPolicyRepository extends NameRepository<SecurityPolicy, Long> {

	@Query("SELECT entity FROM #{#entityName} entity WHERE LOWER(entity.name) like LOWER(:keyword) ")
	List<SecurityPolicy> find(@Param("keyword") String keyword);
}
