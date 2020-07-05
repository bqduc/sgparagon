package net.peaga.domain.enums;
public enum UnitPriceScale {
	High(6), Low(2);

	private int scale;

	UnitPriceScale(int scale) {
		this.scale = scale;
	}

	public int getScale() {
		return scale;
	}

	public static int defaultScale() {
		return Low.scale;
	}
};
