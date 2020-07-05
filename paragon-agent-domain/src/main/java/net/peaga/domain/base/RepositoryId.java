package net.peaga.domain.base;

import java.io.Serializable;

/**
 * Repository data type
 * 
 * @author DucBQ
 */
@SuppressWarnings("serial")
public class RepositoryId implements Serializable{
	private Long objectId;

	public RepositoryId(){
	}

	public RepositoryId(Repository object){
		this.objectId = object.getId();
	}

	public RepositoryId(Long objectId){
		this.objectId = objectId;
	}

	public RepositoryId(String objectId){
		this.objectId = new Long(objectId);
	}

	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

}
