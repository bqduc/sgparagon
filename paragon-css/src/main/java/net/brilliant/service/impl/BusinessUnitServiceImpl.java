package net.brilliant.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import net.brilliant.css.repository.org.BusinessUnitRepository;
import net.brilliant.css.service.org.BusinessUnitService;
import net.brilliant.css.specification.BusinessUnitSpecification;
import net.brilliant.entity.general.BusinessUnit;
import net.brilliant.exceptions.ObjectNotFoundException;
import net.brilliant.framework.model.SearchParameter;
import net.brilliant.framework.repository.BaseRepository;
import net.brilliant.framework.service.GenericServiceImpl;

@Service
public class BusinessUnitServiceImpl extends GenericServiceImpl<BusinessUnit, Long> implements BusinessUnitService{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7067548144456556095L;

	@Inject 
	private BusinessUnitRepository repository;
	
	protected BaseRepository<BusinessUnit, Long> getRepository() {
		return this.repository;
	}

	@Override
	public BusinessUnit getObjectByCode(String code) throws ObjectNotFoundException {
		return super.getOptionalObject(repository.findByCode(code));
	}

	@Override
	protected Page<BusinessUnit> performSearch(String keyword, Pageable pageable) {
		Page<BusinessUnit> fetchedResult = repository.find(keyword, pageable);
		//log.info("Fetched results: " + fetchedResult.getSize());
		return fetchedResult;
	}

	private BusinessUnit parseEntity(List<String> data){
		BusinessUnit.buildObject(data);
		return new BusinessUnit();
		/*return BusinessUnit.getInstance(
				(String)ListUtility.getEntry(data, 0), //Code
				(String)ListUtility.getEntry(data, 2), //First name
				(String)ListUtility.getEntry(data, 1)) //Last name
				.setDateOfBirth(DateTimeUtility.createFreeDate((String)ListUtility.getEntry(data, 4)))
				.setPlaceOfBirth((String)ListUtility.getEntry(data, 5))
				.setNationalId((String)ListUtility.getEntry(data, 6))
				.setNationalIdIssuedDate(DateTimeUtility.createFreeDate((String)ListUtility.getEntry(data, 7)))
				.setNationalIdIssuedPlace((String)ListUtility.getEntry(data, 8))
				.setGender(GenderTypeUtility.getGenderType((String)ListUtility.getEntry(data, 21)))
				.setAddress((String)ListUtility.getEntry(data, 14))
				.setPresentAddress((String)ListUtility.getEntry(data, 14), (String)ListUtility.getEntry(data, 22))
				.setBillingAddress((String)ListUtility.getEntry(data, 15), (String)ListUtility.getEntry(data, 22))
				.setPhones(CommonUtility.safeSubString((String)ListUtility.getEntry(data, 18), 0, 50))
				.setCellPhones(CommonUtility.safeSubString((String)ListUtility.getEntry(data, 19), 0, 50))
				.setOverallExpectation((String)ListUtility.getEntry(data, 28))
				.setOverallExperience((String)ListUtility.getEntry(data, 27))
				.setEmail((String)ListUtility.getEntry(data, 20))
				.setNotes((String)ListUtility.getEntry(data, 29))
			;*/
	}

	@Override
	public Page<BusinessUnit> getObjects(SearchParameter searchParameter) {
		return this.repository.findAll(BusinessUnitSpecification.buildSpecification(searchParameter), searchParameter.getPageable());
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Long count(String countByProperty, Object value) {
		if ("code".equalsIgnoreCase(countByProperty))
			return this.repository.countByCode(value.toString());

		if ("name".equalsIgnoreCase(countByProperty))
			return this.repository.countByName((String)value);

		throw new RuntimeException(String.join("Count by property[", countByProperty, "] with value[", (String)value, "] Not implemented yet!"));
	}
}
