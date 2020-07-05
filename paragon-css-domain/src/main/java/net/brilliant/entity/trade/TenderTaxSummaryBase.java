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

import javax.persistence.MappedSuperclass;

/**
 * Teklif, sipariş, irsaliye ve faturadaki toplam vergiler için
 * ortak ara model. 
 * @author sinan.yumak
 *
 */
@MappedSuperclass
public class TenderTaxSummaryBase extends TaxBase {

	private static final long serialVersionUID = 1L;

}
