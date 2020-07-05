package net.brilliant.entity.general;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.brilliant.auth.entity.UserAccountProfile;
import net.brilliant.domain.entity.general.CatalogueItem;
import net.brilliant.entity.base.BusinessEntity;
import net.brilliant.global.GlobalConstants;

/**
 * An office or business unit.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "business_unit")
@EqualsAndHashCode(callSuper=false)
public class BusinessUnit extends BusinessEntity {
	private static final long serialVersionUID = -1396860561985366652L;

	@Size(min = 3, max = GlobalConstants.SIZE_SERIAL)
	@Column(name = "code")
	private String code;

	@Size(min = 3, max = 200)
	@Column(name = "name_local")
	private String nameLocal;

	@Size(min = 5, max = 200)
	@Column(name = "name", nullable = false)
	private String name;

	@ManyToOne
	@JoinColumn(name = "publish_user_id")//issue_user_id
	private UserAccountProfile publishUserAccount;

	@ManyToOne
	@JoinColumn(name = "issued_user_id")
	private UserAccountProfile issuedUser;

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private BusinessUnit parent;

	@Column(name = "issued_date")
	private Date issuedDate;

	@Column(name = "published_date")
	private Date publishedDate;

	@ManyToOne
	@JoinColumn(name = "spoc_user_id")
	private UserAccountProfile spocUser;

	@ManyToOne
	@JoinColumn(name = "manager_user_id")
	private UserAccountProfile managerUser;

	@ManyToOne
	@JoinColumn(name = "level_id")
	private CatalogueItem level;

	@ManyToOne
	@JoinColumn(name = "business_level_id")
	private CatalogueItem businessLevel;

	@Column(name = "support_level", length=GlobalConstants.SIZE_STRING_TINY)
	private String supportLevel;

	@Column(name = "support_category", length=GlobalConstants.SIZE_STRING_TINY)
	private String supportCategory;

	@Column(name = "management_model", length = GlobalConstants.SIZE_STRING_TINY)
	private String managementModel;

	@Column(name = "address", length = GlobalConstants.SIZE_ADDRESS_DEFAULT)
	private String address;

	@Column(name = "operating_model", length = GlobalConstants.SIZE_STRING_TINY)
	private String operatingModel;

	@Column(name = "activity_status")
	private String activityStatus;

	@Column(name = "organizational_model")
	private String organizationalModel;

	@Column(name = "info", columnDefinition = "TEXT")
	private String info;

	@Override
	public String toString() {
		return "Business unit {" + "id:" + getId() + '}';
	}
}
