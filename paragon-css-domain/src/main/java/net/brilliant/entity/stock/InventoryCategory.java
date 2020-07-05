package net.brilliant.entity.stock;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.brilliant.domain.entity.general.Catalogue;
import net.brilliant.framework.entity.RepoEntity;

/**
 * Entity class ProductCategory
 * 
 * @author ducbq
 */
@Builder
@Data
@Entity
@Table(name = "inventory_category")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class InventoryCategory extends RepoEntity {
	private static final long serialVersionUID = 2574088175219320653L;

	@ManyToOne
	@JoinColumn(name = "product_id")
	private InventoryDetail owner;

	@ManyToOne
	@JoinColumn(name = "category_catalogue_id")
	private Catalogue category;

}
/*
 * 1. sub-category
 * 2. supplementary category
 * 3. extra category
 * 4. specialized subject area
 * 5. main subject category
 * */
