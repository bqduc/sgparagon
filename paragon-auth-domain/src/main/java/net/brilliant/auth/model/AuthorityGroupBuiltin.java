/**
 * 
 */
package net.brilliant.auth.model;

/**
 * @author bqduc
 *
 */
public enum AuthorityGroupBuiltin {
	RoleAdmin("SystemRoles", "System Roles", "Contrast offers system roles for Enterprise on Premises (EOP) customers responsible for administrating and managing the Contrast interface. There are three system roles"),
	RoleClient("OrganizationRoles", "Organization Roles ", "Every user is provided a default role for the default organization. Users who are included in organization access control groups may be granted various roles across different organizations based on their involvement with a specific organization and the applications associated with that organization. There are four primary organization roles and a fifth role used to exclude users from accessing the organization."), 
	RoleUser("ApplicationRoles", "Application Roles", "When you include a user in an organization group, you can define individual application roles - in addition to their default organization role - for more granular control of user permissions with an application. By default, a user won't have any access to applications for which they haven't been assigned a role. There are four primary application roles and a fifth role used to block a user from accessing one or more applications."),
	;
	
	private String code;
	private String name;
	private String info;

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public void setCode(String code) {
		this.code = code;
	}

	private AuthorityGroupBuiltin(String code, String name, String info) {
		this.code = code;
		this.name = name;
		this.info = info;
	}
}
