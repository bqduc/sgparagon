/**
 * 
 */
package net.peaga.domain.general;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.peaga.domain.base.Repository;

/**
 * @author ducbq
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class BusinessUnitProxy extends Repository {
	private static final long serialVersionUID = 8187883513682012140L;

	private String code;

	private String nameLocal;

	private String name;

	private String publishUserAccountCode;

	private String issuedUserCode;

	private BusinessUnitProxy parent;

	private Date issuedDate;

	private Date publishedDate;

	private String spocUserCode;

	private String managerUserCode;

	private String levelCode;

	private String businessLevelCode;

	private String supportLevel;

	private String supportCategory;

	private String managementModel;

	private String address;

	private String operatingModel;

	private String activityStatus;

	private String organizationalModel;

	private String info;
}
