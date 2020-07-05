package net.brilliant.service.mailing;
/**
 * 
 *//*
package net.paramount.service.mailing;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import net.paramount.common.DateTimeUtility;
import net.paramount.exceptions.EcosysException;
import net.paramount.framework.logging.LogService;

*//**
 * @author bqduc
 *
 *//*

@Service
public class MailClientService extends RootService {
	@Inject 
	private LogService log;

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendMail(String subject, String messageBody, String sender, String[] toAddresses, String[] ccAddresses, String[] bccAddresses) throws EcosysException {
		log.info("About to send email at: " + DateTimeUtility.getSystemDateTime());
		try {
      MimeMessage message = javaMailSender.createMimeMessage();

      MimeMessageHelper messageHelper = new MimeMessageHelper(message);
      messageHelper.setTo(toAddresses);
      messageHelper.setText(messageBody, true);
      messageHelper.setSubject(subject);
      javaMailSender.send(message);
			log.info("Email sent at: " + DateTimeUtility.getSystemDateTime());
		} catch (Exception e) {
			throw new EcosysException(e);
		}
	}
}*/