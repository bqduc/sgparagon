package net.brilliant.css.repository.general;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.brilliant.entity.general.Currency;
import net.brilliant.framework.repository.BaseRepository;

@Repository
public interface CurrencyRepository extends BaseRepository<Currency, Long>{
	Optional<Currency> findByCode(String code);
	Long countByCode(String code);

	@Query("SELECT entity FROM #{#entityName} entity WHERE ("
			+ " LOWER(entity.code) like LOWER(CONCAT('%',:keyword,'%')) or "
			+ " LOWER(entity.info) like LOWER(CONCAT('%',:keyword,'%')) "
			+ ")"
	)
	Page<Currency> search(@Param("keyword") String keyword, Pageable pageable);
}
