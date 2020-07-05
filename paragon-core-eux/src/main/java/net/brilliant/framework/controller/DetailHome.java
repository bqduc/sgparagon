/**
 * 
 */
package net.brilliant.framework.controller;

import org.primefaces.event.SelectEvent;

import lombok.Getter;
import lombok.Setter;
import net.brilliant.framework.model.FilterBase;

/**
 * @author bqduc
 *
 */
public abstract class DetailHome<E> extends Home <E, FilterBase> {
	private static final long serialVersionUID = 9111398682757783220L;

	protected static final String PAGE_POSTFIX_DETAIL = "Detail";
	protected static final String PAGE_POSTFIX_BROWSE = "Browse";

	@Setter @Getter
	private Boolean createOther;

	@Setter @Getter
	private Long id;

	protected abstract void onInit();

	public void init() {
		onInit();
  }

	public String save() {
		return performSave();
	}

	protected String performSave() {
		return "success";
	}

	//Events handling
	final public void onParentSelect(SelectEvent<?> event) { 
		performParentSelection(event);
	}

	protected void performParentSelection(SelectEvent<?> event) {
	}
}
