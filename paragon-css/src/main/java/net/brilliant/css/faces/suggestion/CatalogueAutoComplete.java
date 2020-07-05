package net.brilliant.css.faces.suggestion;
/*package net.paramount.css.faces.suggestion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import lombok.Getter;
import lombok.Setter;
import net.paramount.common.ListUtility;
import net.paramount.domain.entity.general.Catalogue;
import net.paramount.service.general.CatalogueService;

@Named
@ViewScoped
public class CatalogueAutoComplete implements Serializable {
	private static final long serialVersionUID = -317477417149115450L;

	@Setter
	@Getter
	private List<Catalogue> selectedItems;

	@Inject
	private CatalogueService businessService;

	public List<String> completeText(String query) {
		List<String> results = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			results.add(query + i);
		}

		return results;
	}

	public List<Catalogue> completeItem(String query) {
		List<Catalogue> allItems = businessService.getObjects();
		List<Catalogue> filteredItems = ListUtility.createDataList();
		Catalogue skin = null;
		for (int i = 0; i < allItems.size(); i++) {
			skin = allItems.get(i);
			if (skin.getName().toLowerCase().contains(query.toLowerCase())) {
				filteredItems.add(skin);
			}
		}

		return filteredItems;
	}

	public List<Catalogue> completeItemContains(String query) {
		List<Catalogue> allItems = businessService.getObjects();
		List<Catalogue> filteredItems = ListUtility.createDataList();

		Catalogue skin = null;
		for (int i = 0; i < allItems.size(); i++) {
			skin = allItems.get(i);
			if (skin.getName().toLowerCase().contains(query.toLowerCase())) {
				filteredItems.add(skin);
			}
		}

		return filteredItems;
	}

	public void onItemSelect(SelectEvent<?> event) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Catalogue Selected", event.getObject().toString()));
	}

	public char getItemGroup(Catalogue item) {
		return item.getName().charAt(0);
	}
}
*/