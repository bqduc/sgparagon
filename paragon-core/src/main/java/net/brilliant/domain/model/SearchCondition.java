/**
 * 
 */
package net.brilliant.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ducbq
 *
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchCondition {
	private String platform;
	private String location;
	private String clientId;
	private String code;
	private String name;
	private String dateFrom;
	private String dateTo;
}
