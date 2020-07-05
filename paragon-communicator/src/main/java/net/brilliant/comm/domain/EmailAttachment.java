/**
 * 
 */
package net.brilliant.comm.domain;

import org.springframework.core.io.InputStreamSource;

import lombok.Builder;

/**
 * @author ducbq
 *
 */
@Builder
public class EmailAttachment {
	private InputStreamSource inputStreamSource;
	private String name;
	private String contentType;
	public InputStreamSource getInputStreamSource() {
		return inputStreamSource;
	}
	public void setInputStreamSource(InputStreamSource inputStreamSource) {
		this.inputStreamSource = inputStreamSource;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

}
