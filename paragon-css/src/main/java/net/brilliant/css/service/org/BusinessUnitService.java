package net.brilliant.css.service.org;

import org.springframework.data.domain.Page;

import net.brilliant.entity.general.BusinessUnit;
import net.brilliant.exceptions.ObjectNotFoundException;
import net.brilliant.framework.model.SearchParameter;
import net.brilliant.framework.service.GenericService;

public interface BusinessUnitService extends GenericService<BusinessUnit, Long>{

  /**
   * Get one business unit with the provided code.
   * 
   * @param code The business unit code
   * @return The business unit
   * @throws ObjectNotFoundException If no such business unit exists.
   */
	BusinessUnit getObjectByCode(String code) throws ObjectNotFoundException;

  /**
   * Get one business units with the provided search parameters.
   * 
   * @param searchParameter The search parameter
   * @return The pageable business units
   */
	Page<BusinessUnit> getObjects(SearchParameter searchParameter);
}
