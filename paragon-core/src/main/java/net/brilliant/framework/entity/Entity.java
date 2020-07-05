/**
 * 
 */
package net.brilliant.framework.entity;

import java.io.Serializable;

/**
 * @author bqduc
 *
 */
public interface Entity extends Comparable<Object>, Serializable {
	Long getId();
	void setId(Long id);
}
