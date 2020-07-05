package net.brilliant.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.brilliant.entity.trade.OrderNote;
import net.brilliant.framework.repository.BaseRepository;
import net.brilliant.framework.service.GenericServiceImpl;
import net.brilliant.repository.trade.OrderNoteRepository;
import net.brilliant.service.trade.OrderNoteService;

@Service
public class OrderNoteServiceImpl extends GenericServiceImpl<OrderNote, Long> implements OrderNoteService{
	private static final long serialVersionUID = -644103846803081016L;
	
	@Inject 
	private OrderNoteRepository repository;
	
	protected BaseRepository<OrderNote, Long> getRepository() {
		return this.repository;
	}
}
