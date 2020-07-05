/**
 * 
 */
package net.brilliant.common;

import org.apache.commons.codec.binary.Base64;

/**
 * @author ducbq
 *
 */
public class StringUtility {
	/**
	 * Tests a given String to see if it contains only valid characters within the Base64 alphabet. Currently the
	 * method treats whitespace as valid.
	 *
	 * @param base64
	 *            String to test
	 * @return <code>true</code> if all characters in the String are valid characters in the Base64 alphabet or if
	 *         the String is empty; <code>false</code>, otherwise
	 *  @since 1.5
	 */
	public static boolean isBase64(final String base64) {
	  return Base64.isBase64(base64);
	}
}
