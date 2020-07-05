/**
 * 
 */
package net.brilliant.auth.model;

/**
 * @author bqduc
 *
 */
public enum BuiltinAuthorityGroup {
	SysSuperAdmin("System Roles", "SuperAdmin", "Super Admin", "The SuperAdmin role is assigned to a select individual or group of individuals who are primarily responsible for the system administration of Contrast. These activities include installation, upgrades, licensing, integrations and other advanced configurations."),
	SysSystemAdministrator("System Roles", "SystemAdministrator", "System Administrator", "The System Administrator role provides one or more users the ability to create, manage and delete organizations and groups. They can view users to assign them to groups."),
	SysObserver("System Roles", "Observer", "Observer", "The Observer role provides one or more users read-only access to organizations, users, applications, groups and traces."),
	OrgAdministrator("Organization Roles", "Administrator", "Administrator", "The user is responsible for configuration and overall management of the organization. This user can license applications, manage user accounts, make purchases (SaaS Only) and perform other advanced configuration functions found in Organization Settings"),
	OrgRulesAdmin("Organization Roles", "Rules Admin", "Rules Admin", "The user has Edit-level privilege to rules as well as the ability to manage rule information at the organizational level. This includes tasks such as adding validation and sanitization methods, and adding organization guidance and references to existing rules"),
	OrgEdit("Organization Roles", "Edit", "Edit", "The user can interact with the full lifecycle of vulnerabilities as well as bring applications online and delete them. This user has no administration capabilities. This role is appropriate for the vast majority of Contrast users. "),
	OrgView("Organization Roles", "View", "View", "The user can access the Contrast interface and browse the organization's applications in read-only mode, but can't perform edits to traces or the application."),
	OrgNoAccess("Organization Roles", "No Access", "No Access", "The user can access the Contrast interface, but can't access the organization(s) that the administrator chose to block."),

	AppAdministrator("Application Roles", "Administrator", "Administrator", "The user has no restrictions within the application, including the ability to manage users' access."),
	AppRulesAdmin("Application Roles", "Rules Admin", "Rules Admin", "The user has the same functionality as an Edit user; however, this user can also edit rules."),
	AppEdit("Application Roles", "Edit", "Edit", "The user can remediate findings, edit attributes about the application, and create or delete applications, and create servers. "),
	AppView("Application Roles", "View", "View", "The user has read-only access to the application, which limits the user to viewing application findings in Contrast. "),
	AppNoAccess("Application Roles", "No Access", "No Access", "The user has no access to the application(s) specifically blocked by an Administrator. "),
	;

	private String category;
	private String name;
	private String displayName;
	private String info;

	private BuiltinAuthorityGroup(String category, String name, String displayName, String info) {
		this.category = category;
		this.name = name;
		this.displayName = displayName;
		this.info = info;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
