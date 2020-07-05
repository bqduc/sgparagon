package net.brilliant.css.repository.general;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.brilliant.entity.general.MeasureUnit;
import net.brilliant.framework.repository.BaseRepository;

@Repository
public interface MeasureUnitRepository extends BaseRepository<MeasureUnit, Long>{
	Optional<MeasureUnit> findByName(String name);
	Optional<MeasureUnit> findByNameLocal(String nameLocal);
	Optional<MeasureUnit> findByCode(String code);
	Long countByCode(String code);
	Long countByName(String name);

	@Query("SELECT entity FROM #{#entityName} entity WHERE ("
			+ " LOWER(entity.code) like LOWER(CONCAT('%',:keyword,'%')) or "
			+ " LOWER(entity.name) like LOWER(CONCAT('%',:keyword,'%')) or "
			+ " LOWER(entity.nameLocal) like LOWER(CONCAT('%',:keyword,'%')) or "
			+ " LOWER(entity.info) like LOWER(CONCAT('%',:keyword,'%')) "
			+ ")"
	)
	Page<MeasureUnit> search(@Param("keyword") String keyword, Pageable pageable);
}
