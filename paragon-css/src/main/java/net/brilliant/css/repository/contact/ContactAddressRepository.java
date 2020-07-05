package net.brilliant.css.repository.contact;

import java.util.List;

import org.springframework.stereotype.Repository;

import net.brilliant.entity.contact.CTAContact;
import net.brilliant.entity.contact.ContactAddress;
import net.brilliant.framework.repository.BaseRepository;

@Repository
public interface ContactAddressRepository extends BaseRepository<ContactAddress, Long> {
	List<ContactAddress> findByOwner(CTAContact contact);
}
