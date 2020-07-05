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

package net.brilliant.entity.options;

/**
 * @author sinan.yumak
 *
 */
public enum SystemOptionKey implements OptionKey {
	CURRENCY_CODE("systemOption.CurrencyCode","VNĐ"),
	CURRENCYDEC_CODE("systemOption.CurrencydecCode","VNĐ"),
	COUNTRY_NAME("systemOption.CountryName","VIỆT NAM"),
	COUNTRY_SHORTNAME("systemOption.CountryShortName","VN"),
	LOCALE("systemOption.Locale","vi_VN"),
	COUNTRY_CODE("systemOption.CountryCode","84");

	private String optionValue;
	private String defaultValue;

	private SystemOptionKey() {
	}

	private SystemOptionKey(String optionValue) {
		this.optionValue = optionValue;
	}

	private SystemOptionKey(String optionValue, String defaultValue) {
		this.optionValue = optionValue;
		this.defaultValue = defaultValue;
	}

	@Override
	public String getDefaultValue() {
		return defaultValue;
	}

	@Override
	public String getValue() {
		return optionValue;
	}

}
