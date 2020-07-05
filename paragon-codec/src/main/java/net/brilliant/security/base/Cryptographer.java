/**
 * 
 */
package net.brilliant.security.base;

import net.brilliant.exceptions.CryptographyException;

/**
 * @author ducbq
 *
 */
public interface Cryptographer {
	byte[] encode(String plainText) throws CryptographyException;
	byte[] decode(byte[] encodedBytes) throws CryptographyException;

	String encode(String message, String secretKey) throws CryptographyException;
	String decode(String encodedmessage, String secretKey) throws CryptographyException;

	String stringEncode(String plainText) throws CryptographyException;
	String stringDecode(String encodedBuffer) throws CryptographyException;
}
