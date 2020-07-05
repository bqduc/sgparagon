/**
 * 
 */
package net.brilliant.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.brilliant.common.CommonUtility;
import net.brilliant.css.service.stock.InventoryService;
import net.brilliant.entity.stock.InventoryImage;
import net.brilliant.framework.logging.LogService;

/**
 * @author ducbq
 *
 */
public class InventoryImageServlet extends ServletCore {
	/**
	 * 
	 */
	private static final long serialVersionUID = -456317972792601513L;
	
	private InventoryService inventoryService;

	@Override
	protected void onInit() throws ServletException {
		this.inventoryService = (InventoryService)this.getBean(InventoryService.class);
		this.log = (LogService)this.getBean(LogService.class);
	}

	@Override
	protected void onGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			/// String productIdParam = request.getParameter("inventoryId");
			String imageIdParam = request.getParameter("imageId");
			if (null == this.inventoryService) {
				inventoryService = (InventoryService)this.getBean(InventoryService.class);
			}

			InventoryImage inventoryImage = inventoryService.getInventoryImage(CommonUtility.parseLong(imageIdParam));
			if (null != inventoryImage) {
				response.getOutputStream().write(inventoryImage.getImageBuffer());
			}
		} catch (Exception e) {
			log.error(e);
		}
	}
	
}
