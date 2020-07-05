/**
 * 
 */
package net.brilliant.auth.domain;

/**
 * @author ducbq
 *
 */
public enum BaseACL {
	//Horizontal - Business privileges
	REGIONAL_MANAGER ("", "RegionalManager", "Regional Managerial", "", "", "", ""), 
	DIVISION_MANAGER ("", "DivisionManager", "Division Managerial", "", "", "", ""), 
	DEPARTMENT_MANAGER ("", "DepartmentManager", "Department Managerial", "", "", "", ""), 

	//Vertical - System privileges
	SYS_ADMIN ("/spaces/**", "SysAdmin", "SysAdmin Authority", "sysmadmin", "sysadmin@ecosphere.net", "SysAdmin", "Nguyễn Ngô Trần"), 
	SYSTEM_ADMINISTRATOR ("/spaces/**", "SystemAdmin", "System Administrator Authority", "systemadmin", "systemadmin@ecosphere.net", "SystemAdmin", "Hồ Lê Phạm Nguyễn Trần"), 
	ADMINISTRATOR ("/spaces/administration/**", "administration", "Administration Authority", "administrator", "administrator@ecosphere.net", "Admin", "Nguyễn Trần"), 
	MANAGER ("/spaces/management/**", "management", "Management Authority", "manager", "manager@ecosphere.net", "Lê Văn", "Manager"), 
	COORDINATOR ("/spaces/coordination/**", "coordination", "Coordination Authority", "coordinator", "coordination@ecosphere.net", "Coordinator", "Hồ Hoàng"), 
	SUBSCRIBER ("/spaces/subscription/**", "subscription", "Subscription Authority", "subscriber", "subscriber@ecosphere.net", "Subscriber", "Ngô Thị"),
	SUBSCRIBER_INTERNAL ("/spaces/subscription/**", "subscription", "Subscription Authority", "subscriber.internal", "subscriber.internal@ecosphere.net", "Subscriber", "Ngô Thị Thuyền Nội Bộ"),
	SUBSCRIBER_EXTERNAL ("/spaces/subscription/**", "subscription", "Subscription Authority", "subscriber.external", "subscriber.external@ecosphere.net", "Subscriber", "Ngô Thị Tàu Bên Ngoài"),
	OSX ("/spaces/osx/**", "osx", "Osxer Authority", "osxer", "osxer@ecosphere.net", "Osxer Authority", "Thái Tông"),
	CRSX ("/spaces/crsx/**", "crsx", "Crsx Authority", "crsxer", "crsxer@ecosphere.net", "Crsxer", "Phùng Hổ"),

	SUBSCRIBER_PROTECTED ("/spaces/subscription/**", "subscription", "Subscription Authority", "subscriber.protected", "subscriber.protected@ecosphere.net", "Subscriber", "Nguyễn Lâm Thị Thuyền Bộ"),
	SUBSCRIBER_PRIVATE ("/spaces/subscription/**", "subscription", "Subscription Authority", "subscriber.private", "subscriber.private@ecosphere.net", "Subscriber", "Trần Thị Thuyền Nội"),

	SUBSCRIBER_RESTRICTED ("/spaces/subscription/**", "subscription", "Subscription Authority", "subscriber.restricted", "subscriber.restricted@ecosphere.net", "Restricted Subscriber", "Nguyễn Lâm Thị Thuyền"),
	;

	private String antMatcher;
	private String authority;
	private String authorityDisplayName;
	private String user;
	private String email;
	private String firstName;
	private String lastName;

	private BaseACL(String antMatcher, String role, String roleDisplayName, String user, String email, String firstName, String lastName) {
		this.antMatcher = antMatcher;
		this.authority = role;
		this.authorityDisplayName = roleDisplayName;
		this.user = user;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getUser() {
		return user;
	}

	public String getAuthority() {
		return authority;
	}

	public String getAntMatcher() {
		return antMatcher;
	}

	public static boolean exists(String user) {
		for (BaseACL acl :BaseACL.values()) {
			if (acl.getUser().equals(user)) {
				return true;
			}
		}
		return false;
	}

	public static BaseACL parse(String user) {
		for (BaseACL acl :BaseACL.values()) {
			if (acl.getUser().equals(user)) {
				return acl;
			}
		}
		return null;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAuthorityDisplayName() {
		return authorityDisplayName;
	}

	public void setAuthorityDisplayName(String authorityDisplayName) {
		this.authorityDisplayName = authorityDisplayName;
	}
}
