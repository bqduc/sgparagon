/**
 * 
 */
package net.brilliant.css.repository.config;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.brilliant.entity.config.Configuration;
import net.brilliant.framework.repository.BaseRepository;

/**
 * @author bqduc
 *
 */
@Repository
public interface ConfigurationRepository extends BaseRepository<Configuration, Long> {
	Optional<Configuration> findByName(String name);

	@Query("SELECT count(entity.id)>0 FROM #{#entityName} entity "
			+ "WHERE ("
			+ " LOWER(entity.name) = LOWER(:name)"
			+ ")"
	)
	boolean isExists(String name);

	@Query("SELECT entity FROM #{#entityName} entity "
			+ "WHERE ("
			+ " LOWER(entity.name) like LOWER(CONCAT('%',:keyword,'%'))"
			+ ")"
	)
	Page<Configuration> search(@Param("keyword") String keyword, Pageable pageable);

	List<Configuration> findByGroup(String group);

	/*@Query("SELECT count(entity.id)>0 FROM #{#entityName} entity "
			+ "WHERE ("
			+ " LOWER(entity.group) = LOWER(:group)"
			+ ")"
	)*/
	boolean existsByGroup(String group);

	boolean existsByName(String name);
}
