/**
 * 
 */
package net.brilliant.domain.model;

/**
 * @author ducbq
 *
 */
public enum AuthenticationStage {
	INVALID_USER("User not exists or not correct"),
	INVALID_PASSWORD("Password not correct"),
	ACCOUNT_INACTIVE("Account is inactive"),
	ACCOUNT_LOCKED("Account has been locked"),
	INVALID_PERMISSION("The permission not valid");

	private String stage;

	private AuthenticationStage(String stage) {
		this.setStage(stage);
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}
}
