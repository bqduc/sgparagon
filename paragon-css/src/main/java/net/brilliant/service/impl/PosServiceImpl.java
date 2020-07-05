package net.brilliant.service.impl;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.brilliant.entity.trade.Pos;
import net.brilliant.exceptions.AppException;
import net.brilliant.exceptions.ObjectNotFoundException;
import net.brilliant.framework.repository.BaseRepository;
import net.brilliant.framework.service.GenericServiceImpl;
import net.brilliant.repository.trade.PosRepository;
import net.brilliant.service.trade.PosService;

@Service
public class PosServiceImpl extends GenericServiceImpl<Pos, Long> implements PosService{
	private static final long serialVersionUID = -8628938623043465764L;

	@Inject 
	private PosRepository repository;
	
	protected BaseRepository<Pos, Long> getRepository() {
		return this.repository;
	}

	@Override
	public Optional<Pos> getByName(String name) throws ObjectNotFoundException {
		return repository.findByName(name);
	}

	@Override
	public Optional<Pos> getByCode(String code) throws ObjectNotFoundException {
		return repository.findByCode(code);
	}

	@Override
	protected Page<Pos> performSearch(String keyword, Pageable pageable) {
		return repository.find(keyword, pageable);
	}

	@Override
	protected Optional<Pos> fetchBusinessObject(Object key) throws AppException {
		return super.getBizObject("findByName", key);
	}
}
