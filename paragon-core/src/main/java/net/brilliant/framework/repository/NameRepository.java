/**
 * 
 */
package net.brilliant.framework.repository;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author bqduc
 *
 */
@NoRepositoryBean
public interface NameRepository<T, PK extends Serializable> extends BaseRepository<T, PK> {
	Optional<T> findByName(String name);
	boolean existsByName(String name);
}
