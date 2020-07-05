/*package net.brilliant.controller;

import java.util.List;
import java.util.Locale;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import net.paramount.auth.entity.Authority;
import net.paramount.auth.service.AuthorityService;
import net.paramount.framework.controller.BaseController;
import net.paramount.msp.faces.model.FacesTeamFacade;
import net.paramount.msp.faces.service.FacesCarService;

*//**
 * @author ducbq
 *//*
@Named(value="roleBrowse")
@ViewScoped
public class RoleBrowseController extends BaseController {
		*//**
	 * 
	 *//*
	private static final long serialVersionUID = -2825754765498119385L;

		private List<FacesTeamFacade> teams;
    //private List<FacesCar> cars;
    private List<String> selectedColors;

    private List<Authority> filteredObjects;

    private Authority selectedObject;
    private List<Authority> selectedObjects; 

    @Inject
    private FacesCarService carService;

    @Inject
    private AuthorityService businessService;

    private List<Authority> businessObjects;
    private List<Authority> selectedBusinessObjects;

    @Override
    public void doPostConstruct() {
    	this.businessObjects = businessService.getObjects();
    }

    public boolean filterByPrice(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if(filterText == null||filterText.equals("")) {
            return true;
        }

        if(value == null) {
            return false;
        }

        return ((Comparable) value).compareTo(Integer.valueOf(filterText)) > 0;
    }

    public void delete() {
    	System.out.println("Deleted!!!");
    }

    public int getRandomPrice() {
        return (int) (Math.random() * 100000);
    }

    public boolean filterByColor(Object value, Object filter, Locale locale) {

        if(filter == null || filter.toString().equals("")) {
            return true;
        }

        if(value == null) {
            return false;
        }

        if(selectedColors.isEmpty()) {
            return true;
        }


        return selectedColors.contains(value.toString());
    }


    public List<FacesTeamFacade> getTeams() {
        return teams;
    }

    public List<String> getBrands() {
        return carService.getBrands();
    }

    public List<String> getColors() {
        return carService.getColors();
    }

    public List<FacesCar> getCars() {
        return cars;
    }

    public List<FacesCar> getCarsCarousel() {
        return cars.subList(0,8);
    }

    public List<Authority> getFilteredObjects() {
        return filteredObjects;
    }

    public void setFilteredObjects(List<Authority> filteredObjects) {
        this.filteredObjects = filteredObjects;
    }

    public List<String> getSelectedColors() {
        return selectedColors;
    }

    public void setSelectedColors(List<String> selectedColors) {
        this.selectedColors = selectedColors;
    }

    public Authority getSelectedObject() {
        return selectedObject;
    }

    public void setSelectedObject(Authority selectedObject) {
        this.selectedObject = selectedObject;
    }

		public List<Authority> getSelectedObjects() {
			return this.selectedObjects;
		}

		public void setSelectedObjects(List<Authority> selectedObjects) {
			this.selectedObjects = selectedObjects;
		}

		public List<Authority> getBusinessObjects() {
			return businessObjects;
		}

		public void setBusinessObjects(List<Authority> businessObjects) {
			this.businessObjects = businessObjects;
		}

		public List<Authority> getSelectedBusinessObjects() {
			return selectedBusinessObjects;
		}

		public void setSelectedBusinessObjects(List<Authority> selectedBusinessObjects) {
			this.selectedBusinessObjects = selectedBusinessObjects;
		}
}
*/