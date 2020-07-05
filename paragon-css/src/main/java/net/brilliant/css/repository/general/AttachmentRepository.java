/**
 * 
 */
package net.brilliant.css.repository.general;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import net.brilliant.domain.entity.Attachment;
import net.brilliant.framework.repository.BaseRepository;

/**
 * @author bqduc
 *
 */
@Repository
public interface AttachmentRepository extends BaseRepository<Attachment, Long> {
	Optional<Attachment> findByName(String name);
}
