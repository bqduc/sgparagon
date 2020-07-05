package net.brilliant.css.service.general;

import java.util.Optional;

import org.springframework.data.domain.Page;

import net.brilliant.entity.general.Currency;
import net.brilliant.exceptions.ObjectNotFoundException;
import net.brilliant.framework.model.SearchParameter;
import net.brilliant.framework.service.GenericService;

public interface CurrencyService extends GenericService<Currency, Long> {

	/**
	 * Get one Currency with the provided alphabetic code.
	 * 
	 * @param alphabeticCode
	 *            The Currency alphabetic code
	 * @return The Currency
	 * @throws ObjectNotFoundException
	 *             If no such Currency exists.
	 */
	Optional<Currency> getByCode(String alphabeticCode) throws ObjectNotFoundException;

	/**
	 * Get one Measure units with the provided search parameters.
	 * 
	 * @param searchParameter
	 *            The search parameter
	 * @return The pageable Measure units
	 */
	Page<Currency> getObjects(SearchParameter searchParameter);

}
