package net.brilliant.component;

import java.text.MessageFormat;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;

import org.omnifaces.util.Messages;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by rmpestano.
 */
@Component
@Named
@ApplicationScoped
public class FacesUtilitiesImpl implements FacesUtilities {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7818567038759597481L;

	@PostConstruct
	public void init() {
	}

	public void addDetailMessage(String message) {
		addDetailMessage(message, null);
	}

	public void addDetailMessage(String message, FacesMessage.Severity severity) {

		FacesMessage facesMessage = Messages.create("").detail(message).get();
		if (severity != null && severity != FacesMessage.SEVERITY_INFO) {
			facesMessage.setSeverity(severity);
		}
		Messages.add(null, facesMessage);
	}

	/*@Produces
	public List<Car> getCars() {
		return cars;
	}*/

	public boolean isUserInRole(String role) {
		// get security context from thread local
		SecurityContext context = SecurityContextHolder.getContext();
		if (context == null)
			return false;

		Authentication authentication = context.getAuthentication();
		if (authentication == null)
			return false;

		for (GrantedAuthority auth : authentication.getAuthorities()) {
			if (role.equals(auth.getAuthority()))
				return true;
		}

		return false;
	}

	@Override
	public String format(String message, Object... arguments) {
		return MessageFormat.format(message, arguments);
	}
}
