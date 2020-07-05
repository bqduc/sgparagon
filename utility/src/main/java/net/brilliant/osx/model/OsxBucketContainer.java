/**
 * 
 */
package net.brilliant.osx.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.brilliant.common.ListUtility;

/**
 * @author bqduc
 *
 */
public class OsxBucketContainer {
	private OfficeSuiteTarget suiteTargeted;
	private Map<Object, Object> bucketData = null;
	private List<Object> container;

	private OsxBucketContainer() {
		this.bucketData = new HashMap<>();
	}

	public OsxBucketContainer(Object[] values) {
		this.container = ListUtility.createArrayList();
		for (int idx = 0; idx < values.length; idx++) {
			this.container.add(values[idx]);
		}
	}

	public List<Object> getContainer() {
		return container;
	}

	public void setContainer(List<Object> container) {
		this.container = container;
	}

	public static OsxBucketContainer instance() {
		OsxBucketContainer dataBucket = new OsxBucketContainer();
		return dataBucket;
	}

	public static OsxBucketContainer getInstance(OfficeSuiteTarget suiteTargeted) {
		OsxBucketContainer dataBucket = new OsxBucketContainer();
		dataBucket.setSuiteTargeted(suiteTargeted);
		return dataBucket;
	}

	public Map<Object, Object> getBucketData() {
		return bucketData;
	}

	public Object getBucketedData(Object key){
		return bucketData.get(key);
	}

	public void setBucketData(Map<Object, Object> bucketData) {
		this.bucketData = bucketData;
	}

	public OsxBucketContainer putAll(Map<Object, Object> values) {
		this.bucketData.putAll(values);
		return this;
	}

	public OsxBucketContainer put(Object key, Object value) {
		this.bucketData.put(key, value);
		return this;
	}

	public Object get(Object key) {
		if (this.bucketData.containsKey(key))
			return this.bucketData.get(key);

		return null;
	}

	public boolean containsKey(Object key) {
		return this.bucketData.containsKey(key);
	}

	public Object pull(Object key) {
		if (this.bucketData.containsKey(key))
			return this.bucketData.remove(key);

		return null;
	}

	public OfficeSuiteTarget getSuiteTargeted() {
		return suiteTargeted;
	}

	public void setSuiteTargeted(OfficeSuiteTarget suiteTargeted) {
		this.suiteTargeted = suiteTargeted;
	}

	public Set<Object> getKeys(){
		return this.bucketData.keySet();
	}
}
