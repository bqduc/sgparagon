/**
 * 
 */
package net.brilliant.osx.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import lombok.Builder;

/**
 * @author bqduc
 *
 */
@Builder
public class DataWorkbook extends DataPackage {
	@Builder.Default
	private Map<Object, DataWorksheet> worksheets = new HashMap<>();

	public DataWorksheet getWorksheet(Object key) {
		if (!this.worksheets.containsKey(key))
			return null;

		return this.worksheets.get(key);
	}

	public DataWorkbook put(Object key, DataWorksheet worksheet) {
		this.worksheets.put(key, worksheet);
		return this;
	}

	public Set<?> getKeys(){
		return this.worksheets.keySet();
	}

	public Collection<DataWorksheet> datasheets(){
		return this.worksheets.values();
	}

	public DataWorksheet getDatasheet(Object key){
		return this.worksheets.get(key);
	}
}
