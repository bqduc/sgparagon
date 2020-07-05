/**
 * 
 */
package net.brilliant.entity.trade;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.brilliant.entity.general.MoneySet;
import net.brilliant.entity.general.WorkBunch;
import net.brilliant.framework.entity.RepoEntity;
import net.brilliant.model.PaymentType;

/**
 * @author ducbq
 *
 */
@Data
@Entity
@Table(name="PAYMENT_ITEM")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
    name="line_type", //columnDefinition = "INTEGER(2)", 
    discriminatorType=DiscriminatorType.INTEGER
)
@DiscriminatorValue("0")
@EqualsAndHashCode(callSuper=false)
public class PaymentItem extends RepoEntity {
	private static final long serialVersionUID = -8190571934748995418L;

	@ManyToOne
  @JoinColumn(name="PAYMENT_ID")
  private Payment owner;
  
  @Column(name="line_type", insertable=false, updatable=false)
  @Enumerated(EnumType.ORDINAL)
  private PaymentType lineType = PaymentType.Cash;
  
  @Column(name="LINE_CODE", length=10)
  private String lineCode;
  
  @Column(name="INFO")
  private String info;
  
  @Embedded
  @AttributeOverrides( {
      @AttributeOverride(name="currency", column=@Column(name="CCY")),
      @AttributeOverride(name="value",    column=@Column(name="CCYVAL")),
      @AttributeOverride(name="localAmount", column=@Column(name="LCYVAL"))
  })
  private MoneySet amount = new MoneySet();

  @Column(name="PAYMENT_TABLE_REFERENCE_ID")
  private Long paymentTableReferenceId;
  
  @Column(name="MATCHING_FINISHED")
  private Boolean matchingFinished = false;
  
  @ManyToOne
  @JoinColumn(name="WORKBUNCH_ID")
  private WorkBunch workBunch;
  
	public boolean isPromissory() { 
		return false;
	}

	public boolean isCheque() { 
		return false;
	}

	public boolean isClientPromissory() {
		return false;
	}
	
	public boolean isClientCheque() {
		return false;
	}   
}
