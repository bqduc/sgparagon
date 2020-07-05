/*
 * Copyleft 2007-2011 Ozgur Yazilim A.S.
 *
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 * http://www.gnu.org/licenses/lgpl.html
 *
 * www.tekir.com.tr
 * www.ozguryazilim.com.tr
 *
 */

package net.brilliant.entity.trade;

import net.brilliant.entity.general.Money;
import net.brilliant.entity.general.MoneySet;
import net.brilliant.entity.general.Quantity;

/**
 * Generic nterface for invoice item.
 * 
 * @author haky
 */
public interface InvoiceItem {
    Long getId();
    String getName();
    String getInfo();
    String getLineCode();
    Quantity getQuantity();
    Money getUnitPrice();
    MoneySet getAmount();
}
