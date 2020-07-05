package net.brilliant.css.repository.stock;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.brilliant.entity.stock.InventoryDetail;
import net.brilliant.framework.repository.BaseRepository;

@Repository
public interface ProductProfileRepository extends BaseRepository<InventoryDetail, Long> {
	@Query("SELECT entity FROM #{#entityName} entity WHERE ("
			+ " LOWER(entity.owner.code) like LOWER(CONCAT('%',:keyword,'%')) or "
			+ " LOWER(entity.owner.barcode) like LOWER(CONCAT('%',:keyword,'%')) or "
			+ " LOWER(entity.owner.name) like LOWER(CONCAT('%',:keyword,'%')) or "
			+ " LOWER(entity.owner.translatedName) like LOWER(CONCAT('%',:keyword,'%')) or "
			+ " LOWER(entity.composition) like LOWER(CONCAT('%',:keyword,'%')) "
			+ ")"
	)
	Page<InventoryDetail> search(@Param("keyword") String keyword, Pageable pageable);
}
