/**
 * 
 */
package net.nep.facade;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.brilliant.common.ListUtility;
import net.brilliant.domain.entity.Attachment;
import net.brilliant.domain.model.dto.FacadeCore;
import net.brilliant.entity.stock.InventoryCore;
import net.brilliant.entity.stock.InventoryDetail;
import net.brilliant.entity.stock.InventoryImage;
import net.brilliant.entity.stock.InventoryPrice;

/**
 * @author ducbq
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class ProductProfile extends FacadeCore {
	private static final long serialVersionUID = -1131146194417567413L;

	private InventoryCore core;
	private InventoryDetail profile;
	private InventoryPrice profileDetail;

	@Builder.Default
	private List<Attachment> images = ListUtility.createList();

	@Builder.Default
	List<InventoryImage> inventoryImages = ListUtility.createList();

	@Builder.Default
	private Boolean changedImages = Boolean.FALSE;

	private String serial;

	public void addAttachment(Attachment attachment) {
		images.add(attachment);
	}
}
