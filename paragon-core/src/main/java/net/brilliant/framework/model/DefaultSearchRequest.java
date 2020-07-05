/**
 * 
 */
package net.brilliant.framework.model;

/**
 * @author bqduc
 *
 */
public class DefaultSearchRequest extends SearchSpec{
	public static final String fieldCode = "code";

	private String code;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
