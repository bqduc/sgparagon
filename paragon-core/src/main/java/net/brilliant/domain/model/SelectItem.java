/**
 * 
 */
package net.brilliant.domain.model;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.brilliant.common.CommonConstants;

/**
 * @author bqduc
 *
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SelectItem {
	@Setter
	@Getter
	private Long id;

	@Setter
	@Getter
	private String code;

	@Setter
	@Getter
	private String name;

	@Setter
	@Getter
	private String translatedName;

	public SelectItem(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public SelectItem(long id, String code, String name) {
		this.id = id;
		this.code = code;
		this.name = name;
	}

	public SelectItem instance(Long key, String code, String name){
		return SelectItem.builder()
				.id(key)
				.code(code)
				.name(name)
				.build();
	}

	public SelectItem instance(Long key, Map<String, Object> properties){
		return SelectItem.builder()
				.id(key)
				.code((String)properties.get(CommonConstants.PROPERTY_CODE))
				.name(properties.containsKey(CommonConstants.PROPERTY_NAME)?(String)properties.get(CommonConstants.PROPERTY_NAME):"")
				.translatedName(properties.containsKey(CommonConstants.PROPERTY_NAME_LOCAL)?(String)properties.get(CommonConstants.PROPERTY_NAME_LOCAL):"")
				.build();
	}
}