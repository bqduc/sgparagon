/**
 * 
 */
package net.brilliant.model;

import lombok.Builder;

/**
 * @author ducbq
 *
 */
@Builder
public class CorpTimeZone {
	private String id;
	private String displayName;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}
