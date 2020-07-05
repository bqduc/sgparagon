/**
 * 
 */
package net.peaga.domain.agricultural;

import net.peaga.domain.base.Repository;

/**
 * @author ducbq
 *
 */
@SuppressWarnings("serial")
public class Pond extends Repository {
	private String code;

	private String location;

	private Float area;

	private Float length;

	private Float width;

	private Float depth;

	private String dimensions;

	private String comments;

	private String status;

	public Pond(String code, String location, Float area, String status, String comments) {
		super();
		this.code = code;
		this.location = location;
		this.area = area;
		this.comments = comments;
		this.status = status;
	}

	public Pond() {
		super();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Float getArea() {
		return area;
	}

	public void setArea(Float area) {
		this.area = area;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Float getLength() {
		return length;
	}

	public void setLength(Float length) {
		this.length = length;
	}

	public Float getWidth() {
		return width;
	}

	public void setWidth(Float width) {
		this.width = width;
	}

	public Float getDepth() {
		return depth;
	}

	public void setDepth(Float depth) {
		this.depth = depth;
	}

	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}
}
