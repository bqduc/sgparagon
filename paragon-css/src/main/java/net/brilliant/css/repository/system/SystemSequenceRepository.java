package net.brilliant.css.repository.system;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.brilliant.entity.system.Sequence;
import net.brilliant.framework.repository.BaseRepository;

@Repository
public interface SystemSequenceRepository extends BaseRepository<Sequence, Long>{
	Optional<Sequence> findBySerial(String serial);

	@Query("SELECT entity FROM #{#entityName} entity WHERE ("
			+ " LOWER(entity.serial) like LOWER(CONCAT('%',:keyword,'%')) "
			+ ")"
	)
	Page<Sequence> search(@Param("keyword") String keyword, Pageable pageable);
}
