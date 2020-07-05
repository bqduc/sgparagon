/**
 * 
 */
package net.brilliant.comm.config;

import java.util.Map;
import java.util.Optional;
import java.util.Properties;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import net.brilliant.comm.comp.EmailConfigurationHelper;
import net.brilliant.comm.exceptions.CommunicationException;
import net.brilliant.common.ListUtility;
import net.brilliant.css.service.config.ConfigurationService;
import net.brilliant.exceptions.CryptographyException;
import net.brilliant.framework.component.CompCore;
import net.brilliant.global.GlobalConstants;
import net.brilliant.security.GlobalCryptogramRepository;
import net.brilliant.security.base.Cryptographer;

/**
 * @author ducbq
 *
 */
@Component
@Configuration
public class EmailConfiguration extends CompCore {
	//@Inject
	//private EmailConfigProperties emailProperties;

	/**
	 * 
	 */
	private static final long serialVersionUID = -6405466012616526188L;

	@Inject
	private ConfigurationService configurationService;
	
	@Inject
	private EmailConfigurationHelper emailConfigurationHelper;

	@Bean
	public JavaMailSender getMailSender() {
		JavaMailSender mailSender = null;
		try {
			mailSender = configEmailProfile();
		} catch (CommunicationException e) {
			log.error(e);
		}
		return mailSender;
		/*
		Optional<net.paramount.entity.config.Configuration> optConfig = configurationService.getByName("config.email");
		Map<Object, Object> configDetailsMap = ListUtility.createMap();
		if (optConfig.isPresent()) {
			configDetailsMap = optConfig.get().getConfigDetailsMap();
			System.out.println(optConfig.get());
		}

		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

		mailSender.setHost(emailProperties.getHost());
		mailSender.setPort(Integer.parseInt(emailProperties.getPort()));
		mailSender.setUsername(emailProperties.getUsername());
		mailSender.setPassword(emailProperties.getPassword());

		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.smtp.starttls.enable", emailProperties.getSmtpStarttlsEnable());
		javaMailProperties.put("mail.smtp.auth", emailProperties.getSmtpAuth());
		javaMailProperties.put("mail.transport.protocol", emailProperties.getTransportProtocol());
		javaMailProperties.put("mail.debug", emailProperties.getDebug());


		javaMailProperties.put("mail.smtp.ssl.trust", emailProperties.getSmtpSslTrust());
		javaMailProperties.put("email.smtpStartTlsRequired", emailProperties.getSmtpStartTlsRequired());
		javaMailProperties.put("email.transportProtocol", emailProperties.getTransportProtocol());
		javaMailProperties.put("email.encoding", emailProperties.getEncoding());

		mailSender.setJavaMailProperties(javaMailProperties);
		return mailSender;
		*/
	}

	private void checkAndConfigureEmailService() {
		this.emailConfigurationHelper.configureEmailService();
	}

	private JavaMailSender configEmailProfile() throws CommunicationException {
		checkAndConfigureEmailService();
		Optional<net.brilliant.entity.config.Configuration> optConfig = configurationService.getByName(GlobalConstants.CONFIG_ENTRY_NAME_EMAIL);
		Map<Object, Object> configDetailsMap = ListUtility.createMap();
		if (!optConfig.isPresent()) {
			throw new CommunicationException("There is no configuration for email!");
		}

		Properties javaMailProperties = null;
		JavaMailSenderImpl mailSender = null;
		GlobalCryptogramRepository globalCryptogramRepository = null;
		Cryptographer cryptographer = null;
		try {
			configDetailsMap = optConfig.get().getConfigDetailsMap();

			mailSender = new JavaMailSenderImpl();

			globalCryptogramRepository = GlobalCryptogramRepository.getInstance();
			cryptographer = globalCryptogramRepository.getDefaultCryptographer();

			mailSender.setHost((String) configDetailsMap.get(GlobalConstants.CONFIG_EMAIL_HOST));
			mailSender.setPort(Integer.parseInt((String) configDetailsMap.get(GlobalConstants.CONFIG_EMAIL_PORT)));
			mailSender.setUsername(cryptographer.decode((String) configDetailsMap.get(GlobalConstants.CONFIG_EMAIL_USER_NAME), GlobalCryptogramRepository.SECRET_KEY));
			mailSender.setPassword(cryptographer.decode((String) configDetailsMap.get(GlobalConstants.CONFIG_EMAIL_PASSWORD), GlobalCryptogramRepository.SECRET_KEY));

			javaMailProperties = new Properties();
			javaMailProperties.put(GlobalConstants.CONFIG_EMAIL_START_TLS_ENABLE, configDetailsMap.get(GlobalConstants.CONFIG_EMAIL_START_TLS_ENABLE));
			javaMailProperties.put(GlobalConstants.CONFIG_EMAIL_AUTH, configDetailsMap.get(GlobalConstants.CONFIG_EMAIL_AUTH));
			javaMailProperties.put(GlobalConstants.CONFIG_EMAIL_TRANSPORT_PROTOCOL, configDetailsMap.get(GlobalConstants.CONFIG_EMAIL_TRANSPORT_PROTOCOL));
			javaMailProperties.put(GlobalConstants.CONFIG_EMAIL_DEBUG, configDetailsMap.get(GlobalConstants.CONFIG_EMAIL_DEBUG));
			javaMailProperties.put(GlobalConstants.CONFIG_EMAIL_SSL_TRUST, configDetailsMap.get(GlobalConstants.CONFIG_EMAIL_SSL_TRUST));
			javaMailProperties.put(GlobalConstants.CONFIG_EMAIL_START_TLS_REQUIRED, configDetailsMap.get(GlobalConstants.CONFIG_EMAIL_START_TLS_REQUIRED));
			javaMailProperties.put(GlobalConstants.CONFIG_EMAIL_TRANSPORT_PROTOCOLX, configDetailsMap.get(GlobalConstants.CONFIG_EMAIL_TRANSPORT_PROTOCOLX));
			javaMailProperties.put(GlobalConstants.CONFIG_EMAIL_ENCODING, configDetailsMap.get(GlobalConstants.CONFIG_EMAIL_ENCODING));

			mailSender.setJavaMailProperties(javaMailProperties);
		} catch (CryptographyException e) {
			throw new CommunicationException(e);
		}
		return mailSender;
	}
}
