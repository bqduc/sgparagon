package net.brilliant.comm.domain;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import net.brilliant.comm.global.CommunicatorConstants;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CorpMimeMessage {
	private String from;
	private String[] recipients;
	private String[] recipientsCc;
	private String[] recipientsBcc;
	private String subject;
	private String body;

	@Builder.Default
	private String contentType = CommunicatorConstants.ContentTypes_TEXT_HTML_UTF8;
	private List<EmailAttachment> attachments;
	private Map<String, Object> definitions;
	private Locale locale;

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public List<EmailAttachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<EmailAttachment> attachments) {
		this.attachments = attachments;
	}

	public void addAttachments(List<EmailAttachment> attachments) {
		if (null==this.attachments) {
			this.attachments = attachments;
		}else {
			this.attachments.addAll(attachments);
		}
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String[] getRecipients() {
		return recipients;
	}

	public void setRecipients(String[] recipients) {
		this.recipients = recipients;
	}

	public String[] getRecipientsCc() {
		return recipientsCc;
	}

	public void setRecipientsCc(String[] recipientsCc) {
		this.recipientsCc = recipientsCc;
	}

	public String[] getRecipientsBcc() {
		return recipientsBcc;
	}

	public void setRecipientsBcc(String[] recipientsBcc) {
		this.recipientsBcc = recipientsBcc;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Map<String, Object> getDefinitions() {
		return definitions;
	}

	public void setDefinitions(Map<String, Object> definitions) {
		this.definitions = definitions;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

}
