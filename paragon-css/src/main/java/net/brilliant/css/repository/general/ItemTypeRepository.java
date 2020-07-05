package net.brilliant.css.repository.general;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.brilliant.entity.general.ItemType;
import net.brilliant.framework.repository.BaseRepository;

@Repository
public interface ItemTypeRepository extends BaseRepository<ItemType, Long>{
	@Query("SELECT entity FROM #{#entityName} entity WHERE ("
			+ " LOWER(entity.code) like LOWER(CONCAT('%',:keyword,'%')) "
			+ ")"
	)
	Page<ItemType> search(@Param("keyword") String keyword, Pageable pageable);

	@Query("SELECT entity FROM #{#entityName} entity WHERE ("
			+ " LOWER(entity.code) like LOWER(CONCAT('%',:keyword,'%')) "
			+ ")"
	)
	List<ItemType> find(@Param("keyword") String keyword);

	ItemType findByCode(String code);
	ItemType findByName(String name);
}
