package net.brilliant.css.faces.conversion;
/*package net.paramount.css.faces.conversion;

import javax.faces.application.FacesMessage;
import javax.faces.convert.ConverterException;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

import net.paramount.domain.entity.general.Catalogue;
import net.paramount.framework.faces.ConverterCore;
import net.paramount.global.GlobalConstants;
import net.paramount.service.general.CatalogueService;

@Named
@Service
public class CatalogueConverter extends ConverterCore<Catalogue> {
	@Inject
	private CatalogueService service;

	@Override
	protected Catalogue objectFromString(String value) {
		Catalogue asObject = null;
		if (value != null && value.trim().length() > 0) {
			try {
				if (GlobalConstants.NONE_OBJECT_ID==Long.parseLong(value))
					return null;

				asObject = service.getObject(Long.valueOf(value));
			} catch (NumberFormatException e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Catalogue Conversion Error", "Not a valid generic item."));
			}
		} 
		return asObject;
	}

	@Override
	protected String objectToString(Catalogue object) {
		String businessObjectSpec = null;
		if (object != null) {
			businessObjectSpec = new StringBuilder()
					.append(object.getId())
					.toString();
		} 
		return businessObjectSpec;
	}
}
*/