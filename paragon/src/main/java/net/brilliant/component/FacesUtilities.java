package net.brilliant.component;

import java.io.Serializable;

import javax.faces.application.FacesMessage;

public interface FacesUtilities extends Serializable {
	void init();

	void addDetailMessage(String message);

	void addDetailMessage(String message, FacesMessage.Severity severity);

	boolean isUserInRole(String role);

	String format(String message, Object ...arguments);
}
