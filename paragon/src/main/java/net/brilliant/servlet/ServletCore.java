/**
 * 
 */
package net.brilliant.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import net.brilliant.framework.logging.LogService;

/**
 * @author ducbq
 *
 */
public abstract class ServletCore extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5096169791703193365L;

	protected LogService log;

	protected Object getBean(Class<?> beanClass) {
		ServletContext context = getServletContext();
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
		return ctx.getBean(beanClass);
	}

	protected void onInit() throws ServletException {
	}

	protected void onGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	@Override
	public void init() throws ServletException {
		this.log = (LogService)this.getBean(LogService.class);
		onInit();
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		onGet(request, response);
	}
}
