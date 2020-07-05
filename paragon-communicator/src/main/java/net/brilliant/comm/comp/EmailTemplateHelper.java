/**
 * 
 */
package net.brilliant.comm.comp;

import java.io.IOException;
import java.util.Locale;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import net.brilliant.comm.global.CommunicatorConstants;
import net.brilliant.common.CommonUtility;
import net.brilliant.framework.component.CompCore;

/**
 * @author ducbq
 *
 */
@Component
public class EmailTemplateHelper extends CompCore {
	private static final long serialVersionUID = -1213645548853344008L;

	private String emailTemplateLoadingDir;

	@Inject
	private Configuration freemarkerConfig;

	public String getEmailTemplateLoadingDir() {
		return emailTemplateLoadingDir;
	}

	public void setEmailTemplateLoadingDir(String emailTemplateLoadingDir) {
		this.emailTemplateLoadingDir = emailTemplateLoadingDir;
	}

	public String getEmailMessageText(String templateId, Locale locale, Object model) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		String emailTemplateDir = this.getEmailTemplateLoadingDir();
		if (CommonUtility.isEmpty(emailTemplateDir)) {
			emailTemplateDir = CommunicatorConstants.DEFAULT_LOADING_TEMPLATE_DIRECTORY;
			log.info("The loading email template directory is empty, using the default email loading template: " + CommunicatorConstants.DEFAULT_LOADING_TEMPLATE_DIRECTORY);
		}

		freemarkerConfig.setClassForTemplateLoading(this.getClass(), emailTemplateDir);
		Template template = freemarkerConfig.getTemplate(templateId, locale);
		return FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
	}
}
