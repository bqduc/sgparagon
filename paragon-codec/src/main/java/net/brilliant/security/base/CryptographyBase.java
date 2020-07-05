/**
 * 
 */
package net.brilliant.security.base;

import javax.crypto.spec.SecretKeySpec;

import net.brilliant.exceptions.CryptographyException;
import net.brilliant.security.SecretAlgorithm;

/**
 * @author ducbq
 *
 */
public abstract class CryptographyBase {
	protected static byte[] privateSecretKeyRaw = { 
			(byte) 0xA5, (byte) 0x01, (byte) 0x7B, (byte) 0xE5,
			(byte) 0x23, (byte) 0xCA, (byte) 0xD4, (byte) 0xD2,
			(byte) 0xC6, (byte) 0x5F, (byte) 0x7D, (byte) 0x8B,
			(byte) 0x0B, (byte) 0x9A, (byte) 0x3C, (byte) 0xF1 };
	
	protected static final String SECRET_KEY_AES = "stackjava.com.if";


	protected static final String SALT_PREFIX = "{{";
	protected static final String SALT_POSFIX = "}}";

	protected static final SecretKeySpec skeySpecDES = new SecretKeySpec(SECRET_KEY_AES.getBytes(), SecretAlgorithm.DES.name());
	
	protected String addSalts(String buffer) {
		return new StringBuilder(SALT_PREFIX).append(buffer).append(SALT_POSFIX).toString();
	}

	protected String eliminateSalts(String buffer) {
		if (buffer.startsWith(SALT_PREFIX) && buffer.endsWith(SALT_POSFIX))
			return buffer.substring(SALT_PREFIX.length(), buffer.length() - SALT_POSFIX.length());

		return buffer;
	}

	protected String  doEncode(String message, String secretKey) throws CryptographyException {
		throw new CryptographyException("Not implemented!");
	}

	protected String  doDecode(String  message, String secretKey) throws CryptographyException {
		throw new CryptographyException("Not implemented!");
	}

	public byte[] encode(String plainText) throws CryptographyException {
		return null;//performEncode(plainText);
	}

	public byte[] decode(byte[] encodedBytes) throws CryptographyException {
		return null;//performDecode(encodedBytes);
	}

	public String stringEncode(String plainText) throws CryptographyException {
		return performStringEncode(plainText);
	}

	public String stringDecode(String encodedBuffer) throws CryptographyException {
		return performStringDecode(encodedBuffer);
	}

	protected String performEncode(String plainText) throws CryptographyException {
		throw new CryptographyException("Not implemented!");
	}

	protected byte[] performDecode(byte[] encodedBytes) throws CryptographyException {
		throw new CryptographyException("Not implemented!");
	}

	protected String performStringEncode(String plainText) throws CryptographyException {
		throw new CryptographyException("Not implemented!");
	}

	protected String performStringDecode(String encodedBuffer) throws CryptographyException {
		throw new CryptographyException("Not implemented!");
	}

	public String encode(String message, String secretKey) throws CryptographyException {
		return doEncode(message, secretKey);
	}

	public String decode(String message, String secretKey) throws CryptographyException {
		return doDecode(message, secretKey);
	}
}
