package net.peaga.domain.enums;

/**
 * @author DucBQ
 *
 */
public enum ProductType {
	Unknown, //0
	Product, //1
	Service, //2
	Expense, //3
	Discount, //4
	DocumentExpense, //5
	DocumentDiscount, //6
	Fee, //7
	DocumentFee, //8
	ContactDiscount, //9 We'll use to keep track of discount lines from the current card. 
	DiscountAddition, //10 including tax reductions
	ExpenseAddition; //11 including tax expense

	public static ProductType fromInteger(int anOrdinal) {
		for (ProductType type : values()) {
			if ( type.ordinal() == anOrdinal ) {
				return type;
			}
		}
		return ProductType.Unknown;
	}
}
