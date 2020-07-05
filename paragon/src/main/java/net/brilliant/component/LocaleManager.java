/**
 * 
 */
package net.brilliant.component;

import java.io.IOException;
import java.util.Locale;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

import org.omnifaces.util.Faces;

import net.brilliant.common.CommonUtility;
import net.brilliant.i18n.GlobalDataRepository;

/**
 * @author ducbq
 *
 */
@ManagedBean
@SessionScoped
public class LocaleManager {
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
  	GlobalDataRepository.builder().build().switchLocale(locale);
    FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    try {
			Faces.redirect("/index.jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}
  }
}
