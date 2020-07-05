/**
 * 
 */
package net.brilliant.comm.global;

/**
 * @author ducbq
 *
 */
public interface CommunicatorConstants {
	static final String DEFAULT_LOADING_TEMPLATE_DIRECTORY = "/emailTemplate/";
	//static final String PROP_TEMPLATE_ID = "templateId";
	static final String PROP_MAIL_OBJECT = "mailObject";
	
	static final String ContentTypes_TEXT_PLAIN = "text/plain";
	static final String ContentTypes_TEXT_HTML_UTF8 = "text/html;charset=UTF-8";
	
	static final String CTX_MIME_MESSAGE = "mailMessage";
	static final String CTX_MAIL_TEMPLATE_ID = "mailTemplateId";
	static final String CTX_MAIL_TEMPLATE_DIR = "mailTemplateDir";
	static final String CTX_USER_ACCOUNT = "userAccount";
	static final String CTX_USER_TOKEN = "token";
	static final String CTX_USER_CONFIRM_LINK = "confirmLink";

	static final String CTX_DEFAULT_REGISTRATION_SUBJECT = "Welcome to your new account";
}
