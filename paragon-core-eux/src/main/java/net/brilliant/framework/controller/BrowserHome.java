/**
 * 
 */
package net.brilliant.framework.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import lombok.Getter;
import lombok.Setter;
import net.brilliant.common.ListUtility;
import net.brilliant.framework.model.FilterBase;

/**
 * @author bqduc
 *
 */
public abstract class BrowserHome<E, F extends FilterBase> extends Home <E, F> {
	private static final long serialVersionUID = -2784847685814774630L;

	@Setter
	@Getter
	protected F filterModel; 

	@Setter
	@Getter
	protected String instantSearch;

	private List<E> businessObjects = ListUtility.createList();

	@Setter
	@Getter
	protected List<E> selectedObjects = ListUtility.createList();

	@Setter
	@Getter
  protected List<E> filteredObjects = ListUtility.createList();

	protected abstract List<E> doGetBusinessObjects();

	@PostConstruct
  void init() {
  	this.filterModel = createFilterModel();

  	//Loading mandatory business objects
  	this.businessObjects = this.doGetBusinessObjects();
  }

  public F createFilterModel() {
  	return null;
  }

	public List<E> getBusinessObjects() {
		return businessObjects;
	}

	public void setBusinessObjects(List<E> businessObjects) {
		this.businessObjects = businessObjects;
	}

}
