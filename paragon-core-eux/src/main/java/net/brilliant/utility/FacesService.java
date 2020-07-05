package net.brilliant.utility;

import java.io.Serializable;

import javax.faces.application.FacesMessage;

public interface FacesService extends Serializable {
	void init();

	void addDetailMessage(String message);

	void addDetailMessage(String message, FacesMessage.Severity severity);

	boolean isUserInRole(String role);

	String format(String message, Object ...arguments);
}
