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

package net.brilliant.embeddable;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import net.brilliant.common.CommonUtility;

/**
 * 
 * @author haky
 * 
 */
@Embeddable
public class Phone implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "COUNTRY_CODE", length = 3)
	private String countryCode;

	@Column(name = "AREA_CODE", length = 6)
	private String areaCode;

	@Column(name = "PHONE_NUMBER", length = 15)
	private String number;

	@Column(name = "EXTENTION", length = 5)
	private String extention;

	public Phone() {
	}

	public Phone(String countryCode, String areaCode, String number, String extention) {
		super();
		this.countryCode = countryCode;
		this.areaCode = areaCode;
		this.number = number;
		this.extention = extention;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getExtention() {
		return extention;
	}

	public void setExtention(String extention) {
		this.extention = extention;
	}

	@Transient
	public void setFullNumber(String fullNumber) {
		Matcher matcher;
		matcher = Pattern.compile("\\(([0-9]{3})\\) ([0-9]{3}) ([0-9]{2}) ([0-9]{2})([^?\\.]{0,1})([^?\\.]{0,1})([0-9]{0,6})").matcher(fullNumber);
		if (matcher.find()) {
			setAreaCode(matcher.group(1));
			setNumber(matcher.group(2) + matcher.group(3) + matcher.group(4));
			setExtention(matcher.group(7));
		} else {
			clear();
		}
	}

	private void clear() {
		countryCode = "";
		areaCode = "";
		number = "";
		extention = "";
	}

	@Transient
	public String getFullNumber() {
		StringBuilder result = new StringBuilder();

		appendAreaCode(result);
		appendNumber(result);
		appendExtension(result);

		return result.toString();
	}

	public String getFullNumberWithAreaCode() {
		StringBuilder result = new StringBuilder();

		appendCountryCode(result);
		appendAreaCode(result);
		appendNumber(result);
		appendExtension(result);

		return result.toString();
	}

	private void appendCountryCode(StringBuilder sb) {
		if (CommonUtility.isNotEmpty(countryCode))
			sb.append("+").append(countryCode).append(" ");
	}

	private void appendAreaCode(StringBuilder sb) {
		if (CommonUtility.isNotEmpty(areaCode))
			sb.append("(").append(areaCode).append(") ");
	}

	private void appendExtension(StringBuilder sb) {
		if (CommonUtility.isNotEmpty(extention))
			sb.append(" #").append(extention);
	}

	private void appendNumber(StringBuilder sb) {
		if (CommonUtility.isNotEmpty(number)) {
			sb.append(number.substring(0, 3)).append(" ").append(number.substring(3, 5)).append(" ").append(number.substring(5, 7)).append(" ");
		}
	}
}
