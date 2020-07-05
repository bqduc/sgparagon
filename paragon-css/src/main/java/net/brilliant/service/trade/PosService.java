package net.brilliant.service.trade;

import java.util.Optional;

import net.brilliant.entity.trade.Pos;
import net.brilliant.exceptions.ObjectNotFoundException;
import net.brilliant.framework.service.GenericService;

public interface PosService extends GenericService<Pos, Long> {

	/**
	 * Get one Pos with the provided name.
	 * 
	 * @param name
	 *            The Pos name
	 * @return The Pos
	 * @throws ObjectNotFoundException
	 *             If no such Pos exists.
	 */
	Optional<Pos> getByName(String name) throws ObjectNotFoundException;

	/**
	 * Get one Pos with the provided code.
	 * 
	 * @param code
	 *            The Pos code
	 * @return The Pos
	 * @throws ObjectNotFoundException
	 *             If no such Pos exists.
	 */
	Optional<Pos> getByCode(String code) throws ObjectNotFoundException;
}
