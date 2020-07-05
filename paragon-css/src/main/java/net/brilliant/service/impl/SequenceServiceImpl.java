package net.brilliant.service.impl;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.brilliant.css.repository.system.SystemSequenceRepository;
import net.brilliant.css.service.system.SequenceService;
import net.brilliant.css.specification.SequenceSpecification;
import net.brilliant.entity.system.Sequence;
import net.brilliant.exceptions.ObjectNotFoundException;
import net.brilliant.framework.model.SearchParameter;
import net.brilliant.framework.repository.BaseRepository;
import net.brilliant.framework.service.GenericServiceImpl;

@Service
public class SequenceServiceImpl extends GenericServiceImpl<Sequence, Long> implements SequenceService{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5209863588217204283L;

	@Inject 
	private SystemSequenceRepository repository;
	
	protected BaseRepository<Sequence, Long> getRepository() {
		return this.repository;
	}

	@Override
	public Sequence getObjectBySerial(String serial) throws ObjectNotFoundException {
		return super.getOptionalObject(repository.findBySerial(serial));
	}

	@Override
	protected Page<Sequence> performSearch(String keyword, Pageable pageable) {
		return repository.search(keyword, pageable);
	}

	@Override
	public Page<Sequence> getObjects(SearchParameter searchParameter) {
		return this.repository.findAll(SequenceSpecification.buildSpecification(searchParameter), searchParameter.getPageable());
	}
}
