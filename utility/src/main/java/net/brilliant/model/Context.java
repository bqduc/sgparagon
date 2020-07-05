/**
 * 
 */
package net.brilliant.model;

import java.io.Serializable;
import java.util.Map;

import net.brilliant.common.ListUtility;

/**
 * Base Context
 * @author bqduc
 *
 */
public abstract class Context implements Serializable{
	private static final long serialVersionUID = 2622407790323667698L;

	private Map<String, Object> contextData = ListUtility.createMap();

	public Map<String, Object> getContextData() {
		return this.contextData;
	}

	public boolean containsKey(String key){
		return this.contextData.containsKey(key);
	}

	public Object get(String key){
		return this.contextData.get(key);
	}

	public Context put(String key, Object contextData){
		this.contextData.put(key, contextData);
		return this;
	}

	public boolean isEmpty(){
		return this.contextData.isEmpty();
	}

	public Context putAll(Context executionContext){
		this.contextData.putAll(executionContext.getContextData());
		return this;
	}

	public Context context(String key, Object value){
		this.contextData.put(key, value);
		return this;
	}

	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		for (String key :this.contextData.keySet()) {
			buffer.append(key).append("\t: ").append(this.contextData.get(key)).append("\n");
		}
		return buffer.toString();
	}
}
