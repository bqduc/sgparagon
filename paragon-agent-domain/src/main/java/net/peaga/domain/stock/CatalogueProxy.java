package net.peaga.domain.stock;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.peaga.domain.base.Repository;

/**
 * A Book.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class CatalogueProxy extends Repository {
	private static final long serialVersionUID = -6406441893130421058L;

	private java.lang.String name;
	private java.lang.String translatedName;
	private java.lang.Boolean visible;
	private java.lang.Integer sortOrder;
	private java.lang.Boolean beverage;

	private java.lang.Boolean isGroup;
  private Long categoryId; // If this is a group

  private Long parentId;

  private java.util.List<Long> discountIds;
}
