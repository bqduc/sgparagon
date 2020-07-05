/**
 * 
 */
package net.brilliant.framework.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author bqduc
 *
 */
@NoRepositoryBean
public interface BaseRepository<T, PK extends Serializable> extends JpaRepository<T, PK>, JpaSpecificationExecutor<T> {
	Optional<T> findById(PK id);

	Page<T> findAll(Pageable pageable);
	Page<T> findAllByOrderByIdAsc(Pageable pageable);
	//Collection<T> saveAll(Collection<T> collection);

	@Query("SELECT entity FROM #{#entityName} entity WHERE entity.system = true")
	List<T> findVisible();
}
