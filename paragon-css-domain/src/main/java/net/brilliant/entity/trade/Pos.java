/**
 * 
 */
package net.brilliant.entity.trade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import net.brilliant.entity.general.Organization;
import net.brilliant.framework.entity.RepoAuditable;

/**
 * @author ducbq
 *
 */
@Entity
@Table(name = "POS")
public class Pos extends RepoAuditable {
	private static final long serialVersionUID = 6463076116441002875L;

	@Setter
	@Getter
	@Column(name = "CODE", unique = true)
	private String code;

	@Setter
	@Getter
	@Column(name = "NAME")
	private String name;

	@Setter
	@Getter
	@ManyToOne
	@JoinColumn(name = "BANK_ID")
	private Bank bank;

	@Setter
	@Getter
	@ManyToOne
	@JoinColumn(name = "BANK_BRANCH_ID")
	private BankBranch bankBranch;

	@Setter
	@Getter
	@ManyToOne
	@JoinColumn(name = "BANK_ACCOUNT_ID")
	private BankAccount bankAccount;

	@Setter
	@Getter
	@Column(name = "INFO")
	private String info;

	/**
	 * Posun çalışabileceği max. taksit sayısını tutar.
	 */
	@Setter
	@Getter
	@Column(name = "MAX_PERIOD")
	private Integer maxPeriod = 12;

	/**
	 * Organizasyon seviye bilgisini tutar.
	 */
	@Setter
	@Getter
	@ManyToOne
	@JoinColumn(name = "ORGANIZATION_ID")
	//@ForeignKey(name = "FK_POS_ORGANIZATIONID")
	private Organization organization;
}
