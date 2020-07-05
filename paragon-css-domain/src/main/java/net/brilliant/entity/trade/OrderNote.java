/**
 * 
 */
package net.brilliant.entity.trade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.brilliant.auth.entity.UserAccountProfile;
import net.brilliant.entity.contact.CTAContact;
import net.brilliant.entity.doc.DocumentBase;
import net.brilliant.entity.doc.DocumentType;
import net.brilliant.entity.stock.Warehouse;

/**
 * @author ducbq
 *
 */

@Builder
@Entity
@Table(name="ORDER_NOTE")
@NoArgsConstructor
@AllArgsConstructor
public class OrderNote extends DocumentBase {
	private static final long serialVersionUID = 5374753611465150282L;

	@Setter
	@Getter
  @Column(name="ACTION")
  @Enumerated(EnumType.ORDINAL)
  private TradeAction action;
  
	@Setter
	@Getter
  @ManyToOne
  @JoinColumn(name="WAREHOUSE_ID")
  private Warehouse warehouse;
  
	@Setter
	@Getter
  @ManyToOne
  @JoinColumn(name="CONTACT_ID")
  private CTAContact contact;

  /**
   * satışı yapan tezgahtar bilgisini tutar.
   */
	@Setter
	@Getter
  @ManyToOne
  @JoinColumn(name="CLERK_ID")
  private UserAccountProfile clerk;

  /*@OneToMany(mappedBy = "owner", cascade=CascadeType.ALL )
  @Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)*/
	@Builder.Default
	@Setter
	@Getter
  @OneToMany(
  		mappedBy="owner"
      , cascade = CascadeType.ALL
      , orphanRemoval = true
  )
	@LazyCollection(LazyCollectionOption.FALSE)
  private List<OrderItem> items = new ArrayList<OrderItem>();

  @Override
	public DocumentType getDocumentType() {
		return null;
	}

}
