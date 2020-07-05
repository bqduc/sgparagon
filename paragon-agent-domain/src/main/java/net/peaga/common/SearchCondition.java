/**
 * 
 */
package net.peaga.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ducbq
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SearchCondition {
	private String platform;
	private String location;
	private String clientId;
	private String code;
	private String name;
	private String dateFrom;
	private String dateTo;
}
