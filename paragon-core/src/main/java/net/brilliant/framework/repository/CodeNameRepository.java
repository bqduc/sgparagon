/**
 * 
 */
package net.brilliant.framework.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

/**
 * @author bqduc
 *
 */
@NoRepositoryBean
public interface CodeNameRepository<T, PK extends Serializable> extends BaseRepository<T, PK> {
	@Query("SELECT entity FROM #{#entityName} entity WHERE ("
			+ " LOWER(entity.code) like LOWER(CONCAT('%',:keyword,'%')) or "
			+ " LOWER(entity.name) like LOWER(CONCAT('%',:keyword,'%')) "
			+ ")"
	)
	Page<T> find(@Param("keyword") String keyword, Pageable pageable);

	@Query("SELECT entity FROM #{#entityName} entity WHERE LOWER(entity.code) like LOWER(CONCAT('%',:keyword,'%')) or LOWER(entity.name) like LOWER(CONCAT('%',:keyword,'%')) ")
	List<T> find(@Param("keyword") String keyword);
	
	Optional<T> findByCode(String code);
	Optional<T> findByName(String name);

	Long countByCode(String code);
	Long countByName(String name);
}
