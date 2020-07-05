package net.brilliant.framework.model;
/**
 * 
 *//*
package net.paramount.framework.model;

import java.io.Serializable;
import java.util.Map;

import net.paramount.common.ListUtility;

*//**
 * Base Execution Context
 * @author bqduc
 *
 *//*
public abstract class ContextBase implements Serializable{
	*//**
	 * 
	 *//*
	private static final long serialVersionUID = 2220727579730517981L;

	private Map<String, Object> context = ListUtility.createMap();

	public Map<String, Object> getContext() {
		return context;
	}

	public boolean containKey(String key){
		return this.context.containsKey(key);
	}

	public Object get(String key){
		return this.context.get(key);
	}

	public Object getDefaultContext(){
		return (this.context.size()<1)?null:this.context.values().iterator().next();
	}

	public void put(String key, Object contextData){
		this.context.put(key, contextData);
	}

	public boolean isEmpty(){
		return context.isEmpty();
	}

	public ContextBase putAll(ContextBase executionContext){
		this.context.putAll(executionContext.getContext());
		return this;
	}

	public ContextBase context(String key, Object value){
		this.context.put(key, value);
		return this;
	}
}
*/