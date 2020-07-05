package net.peaga.domain.enums;

/**
 * 
 * @author DucBQ
 *
 */
public enum BusinessDocStatus {
	Open,
	Cancelled,
	Rejected,
	Approved,
	Processing,
	Final,
	Closed,
	//For count-note
	Counting, 
	Counted, 
	Editing, 
	Finished, 
	//For tender
	Revisioned, 
	
	Draft,
	Suspended,
	Started,
	Passed,
	Failed,
	All
}
