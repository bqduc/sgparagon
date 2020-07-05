/**
 * 
 */
package net.brilliant.osx.model;

import java.util.Map;

import lombok.Builder;
import net.brilliant.common.ListUtility;

/**
 * @author bqduc
 *
 */
@Builder
public class OfficeDataPackage extends DataPackage {
	@Builder.Default
	private Map<Object, DataPackage> packageData = ListUtility.createMap();

	public DataPackage getDataPackage(final Object key){
		return packageData.get(key);
	}

	public OfficeDataPackage putAll(final Map<Object, ? extends DataPackage> values) {
		this.packageData.putAll(values);
		return this;
	}

	public OfficeDataPackage put(final Object key, final DataPackage value) {
		this.packageData.put(key, value);
		return this;
	}
}
