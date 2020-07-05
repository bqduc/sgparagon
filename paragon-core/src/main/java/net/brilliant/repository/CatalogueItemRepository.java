/**
 * 
 */
package net.brilliant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.brilliant.domain.entity.general.CatalogueItem;
import net.brilliant.framework.repository.CodeNameRepository;

/**
 * @author bqduc
 *
 */
@Repository
public interface CatalogueItemRepository extends CodeNameRepository<CatalogueItem, Long> {

	@Query("SELECT entity FROM #{#entityName} entity WHERE LOWER(entity.code) like LOWER(:keyword) or LOWER(entity.name) like LOWER(:keyword) ")
	List<CatalogueItem> find(@Param("keyword") String keyword);
}
