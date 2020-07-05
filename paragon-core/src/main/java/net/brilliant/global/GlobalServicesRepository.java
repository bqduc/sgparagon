/**
 * 
 */
package net.brilliant.global;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import lombok.Builder;
import net.brilliant.common.BeanUtility;
import net.brilliant.domain.model.SelectItem;

/**
 * @author ducbq
 *
 */
@Builder
public class GlobalServicesRepository {
	public SelectItem getNoneItem() {
		return SelectItem.builder()
		.id(GlobalConstants.NONE_OBJECT_ID)
		.code(GlobalConstants.NONE_OBJECT_CODE)
		.name(GlobalConstants.NONE_OBJECT_NAME)
		.build();
	}

	public Object buildNoneObject(Object targetBean, Map<String, Object> beanProperties) throws RuntimeException {
		try {
			return BeanUtility.buildObject(targetBean, beanProperties);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}
}
