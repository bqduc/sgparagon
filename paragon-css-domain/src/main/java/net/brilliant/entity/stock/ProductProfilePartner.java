package net.brilliant.entity.stock;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.brilliant.entity.contact.ContactCore;
import net.brilliant.framework.entity.RepoAuditable;
import net.brilliant.model.PartnerType;

/**
 * Entity class Product profile and it's parter like vendor, production, ...
 * 
 * @author ducbq
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_profile_partner")
@EqualsAndHashCode(callSuper=false)
public class ProductProfilePartner extends RepoAuditable {
	private static final long serialVersionUID = -6202968427427051360L;

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private InventoryDetail owner;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "issued_date")
	private Date issuedDate;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "expired_date")
	private Date expiredDate;

	@Builder.Default
	@Column(name = "UNIT_PRICE_SCALE")
	@Enumerated(EnumType.ORDINAL)
	private PartnerType partnerType = PartnerType.Unknown;

	@ManyToOne
	@JoinColumn(name = "partner_contact_id")
	private ContactCore partner;
	
}