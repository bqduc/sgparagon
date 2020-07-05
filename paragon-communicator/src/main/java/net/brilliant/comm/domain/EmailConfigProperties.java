/**
 * 
 */
package net.brilliant.comm.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ducbq
 *
 */
@Component
@ConfigurationProperties("email")
public class EmailConfigProperties {
	
	private String host;
	private String port;
	private String username;
	private String password;

	@Value("${email.smtp.starttls.enable}")
	private String smtpStarttlsEnable;
	
	@Value("${email.smtp.auth}")
	private String smtpAuth;
	
	@Value("${email.transport.protocol}")
	private String transportProtocol;
	
	@Value("${email.debug}")
	private String debug;
	
	@Value("${email.smtp.ssl.trust}")
	private String smtpSslTrust;
	
	@Value("${email.smtpStartTlsRequired}")
	private String smtpStartTlsRequired;
	
	@Value("${email.encoding}")
	private String encoding;

	public void setHost(String host) {
		this.host = host;
	}
	
	public String getHost() {
		return host;
	}
	
	public void setPort(String port) {
		this.port = port;
	}
	
	public String getPort() {
		return port;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}

	public String getSmtpStarttlsEnable() {
		return smtpStarttlsEnable;
	}

	public void setSmtpStarttlsEnable(String smtpStarttlsEnable) {
		this.smtpStarttlsEnable = smtpStarttlsEnable;
	}

	public String getSmtpAuth() {
		return smtpAuth;
	}

	public void setSmtpAuth(String smtpAuth) {
		this.smtpAuth = smtpAuth;
	}

	public String getTransportProtocol() {
		return transportProtocol;
	}

	public void setTransportProtocol(String transportProtocol) {
		this.transportProtocol = transportProtocol;
	}

	public String getDebug() {
		return debug;
	}

	public void setDebug(String debug) {
		this.debug = debug;
	}

	public String getSmtpSslTrust() {
		return smtpSslTrust;
	}

	public void setSmtpSslTrust(String smtpSslTrust) {
		this.smtpSslTrust = smtpSslTrust;
	}

	public String getSmtpStartTlsRequired() {
		return smtpStartTlsRequired;
	}

	public void setSmtpStartTlsRequired(String smtpStartTlsRequired) {
		this.smtpStartTlsRequired = smtpStartTlsRequired;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
		
}
