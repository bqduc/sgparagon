/**
 * 
 */
package net.peaga.domain.agricultural;

import java.util.Date;

import net.peaga.domain.base.Repository;

/**
 * @author ducbq
 *
 */
@SuppressWarnings("serial")
public class ProductionPlan extends Repository {
	private String code;

	private String name;

	private Integer duration;

	private Date startedTime;

	private String comments;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Date getStartedTime() {
		return startedTime;
	}

	public void setStartedTime(Date startedTime) {
		this.startedTime = startedTime;
	}

}
