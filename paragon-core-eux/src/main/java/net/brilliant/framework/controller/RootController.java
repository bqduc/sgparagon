/**
 * 
 */
package net.brilliant.framework.controller;

import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.MessageSource;
import org.springframework.web.servlet.LocaleResolver;

import net.brilliant.framework.component.ComponentBase;

/**
 * @author bqduc
 *
 */
public abstract class RootController extends ComponentBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2445529753237451206L;

	protected static final String DEFAULT_PAGE_SIZE = "100";
	protected static final String DEFAULT_PAGE_NUM = "0";

	@Inject
	protected MessageSource persistenceMessageSource;//dbMessageSource

	@Inject
	protected HttpSession httpSession;

	@Inject
	protected HttpServletRequest request;
	
	@Inject 
	protected LocaleResolver localeResolver;

  @Inject 
  protected ServletContext servletContext;

	protected void cachePut(String key, Object data) {
		this.httpSession.setAttribute(key, data);
	}

	protected Object cacheGet(String key) {
		return this.httpSession.getAttribute(key);
	}

	/*protected void routingPage(String pageId) {
		try {
			ExternalContext context = Faces.getExternalContext();
			context.redirect(context.getRequestContextPath() + pageId);
		} catch (Exception e) {
			log.error(e);
		}
	}

	protected void routePage(String pageId) {
		this.routingPage(pageId);
	}

	protected void routePage(String pageId, Boolean invalidateSessionInfoFlag) {
		if (Boolean.TRUE.equals(invalidateSessionInfoFlag)) {
			Faces.getSession().invalidate();
		}
		this.routingPage(pageId);
	}*/
	
	protected Locale getCurrentLocale() {
		return localeResolver.resolveLocale(request);//((SessionLocaleResolver)localeResolver);//LocaleContextHolder.getLocale();
	}
}
