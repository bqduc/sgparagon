package net.peaga.domain.enums;

/**
 * 
 * @author DucBQ
 */
public enum TradeAction {
	Purchase, // 0- Buying
	Sale, // 1- Sales
	PurchseReturn, // 2- Buying Returns
	SaleReturn, // 3- Sales Return
	Transport, // 4- Shipping
	Spending, // 5- Supplies
	Reserved, // 6- The reservation order
	Delivered; // 7- It was delivered to the reservation order.

	public static TradeAction fromInteger(int anOrdinal) {
		for (TradeAction type : values()) {
			if (type.ordinal() == anOrdinal) {
				return type;
			}
		}
		return TradeAction.Purchase;
	}
}