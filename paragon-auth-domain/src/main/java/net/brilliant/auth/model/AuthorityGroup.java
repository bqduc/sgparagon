/**
 * 
 */
package net.brilliant.auth.model;

/**
 * @author bqduc
 *
 */
public enum AuthorityGroup {
	RoleAdmin("ROLE_ADMIN"),
	RoleClient("ROLE_CLIENT"), 
	RoleUser("ROLE_USER"),
	RoleAnonymous("ROLE_ANONYMOUS");
	
	private String code;

	public String getCode() {
		return code;
	}

	private AuthorityGroup(String code) {
		this.code = code;
	}
}
