package net.brilliant.service.trade;

import java.util.Optional;

import net.brilliant.entity.trade.Bank;
import net.brilliant.exceptions.ObjectNotFoundException;
import net.brilliant.framework.service.GenericService;

public interface BankService extends GenericService<Bank, Long> {

	/**
	 * Get one Bank with the provided name.
	 * 
	 * @param name
	 *            The Bank name
	 * @return The Bank
	 * @throws ObjectNotFoundException
	 *             If no such Bank exists.
	 */
	Optional<Bank> getByName(String name) throws ObjectNotFoundException;

	/**
	 * Get one Bank with the provided code.
	 * 
	 * @param code
	 *            The Bank code
	 * @return The Bank
	 * @throws ObjectNotFoundException
	 *             If no such Bank exists.
	 */
	Optional<Bank> getByCode(String code) throws ObjectNotFoundException;
}
