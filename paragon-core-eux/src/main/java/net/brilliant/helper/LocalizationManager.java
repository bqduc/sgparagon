/**
 * 
 *//*
package net.brilliant.helper;

import java.io.IOException;
import java.util.Locale;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.omnifaces.util.Faces;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import net.brilliant.common.CommonUtility;

*//**
 * @author ducbq
 *
 *//*
@Named
@ManagedBean
//@SessionScoped
@Component
@Scope(value = "session",  proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LocalizationManager {
	private Locale locale;

  @PostConstruct
  public void init() {
      locale = CommonUtility.LOCALE_VIETNAMESE; //FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
  }

  public Locale getLocale() {
      return locale;
  }

  public String getLanguage() {
      return locale.getLanguage();
  }

  public void setLanguage(String language) {
  	if ("en".equalsIgnoreCase(language)) {
    	locale = Locale.US;
  	} else {
  		locale = CommonUtility.LOCALE_VIETNAMESE;
  	}
    FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    try {
			Faces.redirect("/index.jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}
  }
}
*/