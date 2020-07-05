package net.brilliant.css.repository.contact;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.brilliant.entity.contact.CTAContact;
import net.brilliant.framework.repository.BaseRepository;

@Repository
public interface ContactRepository extends BaseRepository<CTAContact, Long> {
	Optional<CTAContact> findByEmail(String email);

	Optional<CTAContact> findByCode(String code);
	Long countByCode(String code);
	
  @Query(value = "SELECT entity.code FROM #{#entityName} entity ", nativeQuery = true)
  List<String> findCode();

	@Query("SELECT entity FROM #{#entityName} entity WHERE ("
			+ " LOWER(entity.code) like LOWER(CONCAT('%',:keyword,'%')) or "
			+ " LOWER(entity.accountName) like LOWER(CONCAT('%',:keyword,'%')) or "
			+ " LOWER(entity.title) like LOWER(CONCAT('%',:keyword,'%')) or "
			+ " LOWER(entity.email) like LOWER(CONCAT('%',:keyword,'%')) "
			+ ")"
	)
	Page<CTAContact> search(@Param("keyword") String keyword, Pageable pageable);
}
