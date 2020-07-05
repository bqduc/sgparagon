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
public interface CodeRepository<T, PK extends Serializable> extends BaseRepository<T, PK> {
	Optional<T> findByCode(String code);
}
