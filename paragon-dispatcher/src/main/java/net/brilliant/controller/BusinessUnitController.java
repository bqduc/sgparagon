package net.brilliant.controller;

import java.io.IOException;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.access.AccessDeniedException;

import lombok.Getter;
import lombok.Setter;
import net.brilliant.common.CommonAssert;
import net.brilliant.css.service.org.BusinessUnitService;
import net.brilliant.entity.general.BusinessUnit;
import net.brilliant.framework.controller.DetailHome;

/**
 * @author ducbq
 */
@Named
@ViewScoped
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BusinessUnitController extends DetailHome<BusinessUnit> {
	private static final long serialVersionUID = -8404109612128323252L;

	@Inject
	private BusinessUnitService businessService;

	@Setter @Getter
	private BusinessUnit businessObject;

	public void remove() throws IOException {
		if (!facesService.isUserInRole("ROLE_ADMIN")) {
			throw new AccessDeniedException("User not authorized! Only role <b>admin</b> can remove cars.");
		}

		if (CommonAssert.has(businessObject) && CommonAssert.has(businessObject.getId())) {
			businessService.remove(businessObject);
			facesService.addDetailMessage("Business object " + businessObject.getName() + " removed successfully");
			Faces.getFlash().setKeepMessages(true);
			Faces.redirect("user/car-list.jsf");
		}
	}

	/*public String processSubmit(String action) {
		System.out.println(action);
		businessObject.addProfile(
				ProductProfile.builder()
				.availableDate(Calendar.getInstance().getTime()).build()
		);
		businessService.save(businessObject);
		return "stayBack".equals(action)?"":"inventoryBrowse?faces-redirect=true";
	}*/

	public String handleSubmit() {
		if (Boolean.TRUE.equals(this.getCreateOther()))
			return "taxGroupDetail";

		return "taxGroupBrowse";
	}

	public void clear() {
		businessObject = new BusinessUnit();
		setId(null);
	}

	public boolean isNew() {
		return businessObject == null || businessObject.getId() == null;
	}

	@Override
	protected void onInit() {
		if (Faces.isAjaxRequest()) {
			return;
		}

		if (CommonAssert.has(getId())) {
			//businessObject = businessService.getObject(id);
			this.businessObject = this.businessService.getObject(getId());
		} else if (null==this.businessObject){
			//businessObject = new ProductCore();
			this.businessObject = new BusinessUnit();
		}

	}

	@Override
	protected String performSave() {
		try {
			StringBuilder msg = new StringBuilder("Business object ").append(this.businessObject.getName());
			if (this.businessObject.getId() == null) {
				msg.append(" created successfully");
			} else {
				msg.append(" updated successfully");
			}

			businessService.saveOrUpdate(this.businessObject);

			facesService.addDetailMessage(msg.toString());
			if (Boolean.TRUE.equals(this.getCreateOther())) {
				Faces.redirect("/pages/trade/taxGroupDetail.jsf");
			} else {
				Faces.redirect("/pages/trade/taxGroupBrowse.jsf");
			}
		} catch (Exception e) {
			this.log.error(e);
		}
		return "success";
	}
}
