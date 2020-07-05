/**
 * 
 */
package net.brilliant.component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import net.brilliant.auth.domain.UserSecurityProfile;
import net.brilliant.auth.service.AuthorizationService;
import net.brilliant.common.CommonUtility;
import net.brilliant.framework.component.ComponentBase;
import net.brilliant.global.GlobalConstants;

/**
 * @author ducbq
 *
 */
@Component
@Named(value = "globalDispatcher")
//@ViewScoped
@SessionScoped
public class GlobalDispatcher extends ComponentBase {
	private static final long serialVersionUID = -4189926376687700775L;

	@Inject
	protected HttpSession httpSession;

	@Inject
	protected HttpServletRequest request;
	
	@Inject 
	protected ServletContext servletContext;
	
	@Inject
	private AuthorizationService authorizationService;

	private String failureMessage;

	public UserSecurityProfile getSecurityAccountProfile() {
		UserSecurityProfile securityAccountProfile = null;
		HttpSession session = null;
		try {
			session = session();
			if (null != session) {
				securityAccountProfile = (UserSecurityProfile)session.getAttribute(GlobalConstants.AUTHENTICATED_PROFILE);
			}
		} catch (Exception e) {
			log.error(e);
		}

		if (null == securityAccountProfile) {
			securityAccountProfile = authorizationService.getActiveSecuredProfile();
		}

		return securityAccountProfile;
	}
	
	protected HttpSession session() {
		this.httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		if (null != this.httpSession)
			return this.httpSession;

		if (null != this.request) {
			return this.request.getSession();
		}

		if (null != this.httpSession)
			return this.httpSession;

		try {
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			this.httpSession = attr.getRequest().getSession(true);
		} catch (Exception e) {
			log.error(e);
		}
		return this.httpSession;
		// return attr.getRequest().getSession(true); // true == allow create
	}

	public String getFailureMessage() {
		return failureMessage;
	}

	public void setFailureMessage(String failureMessage) {
		this.failureMessage = failureMessage;
	}

	public String getUserProfileImageContentsAsBase64() {
		InputStream inputStream = null;
		byte[] imageBytes = null;
		UserSecurityProfile securityPrincipalProfile = null;
		try {
			securityPrincipalProfile = this.getSecurityAccountProfile();
		} catch (Exception e) {
			log.error(e);
		}

		if (null==securityPrincipalProfile || null==securityPrincipalProfile.getUserAccount() || null == securityPrincipalProfile.getUserAccount().getProfilePicture()) {
			inputStream = servletContext.getResourceAsStream("/resources/images/anonymous-user-small.png");
			try {
				imageBytes = CommonUtility.getByteArray(inputStream);
			} catch (IOException e) {
				//e.printStackTrace();
			}
		} else {
			imageBytes = securityPrincipalProfile.getUserAccount().getProfilePicture();
		}
		return Base64.getEncoder().encodeToString(imageBytes);
	}
}
