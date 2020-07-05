/**
 * 
 */
package net.brilliant.common;

import org.apache.commons.codec.binary.Base64;

/**
 * @author ducbq
 *
 */
public class SimpleEncryptionEngine {
	private static final String ENCRYPTION_SALT = "裴达克·奎-裴达克·奎";
	private static SimpleEncryptionEngine instance = null;
	static {
		instance = new SimpleEncryptionEngine();
	}

	private String addEncryptionKey(String buffer) {
		return new StringBuilder(buffer).append(ENCRYPTION_SALT).toString();
	}

	private String eliminateEncryptionKey(String buffer) {
		if (!buffer.contains(ENCRYPTION_SALT))
			return buffer;

		return buffer.substring(0, buffer.length()-ENCRYPTION_SALT.length());
	}

	private String doEncode(String data) {
		String encodingBuffer = addEncryptionKey(data);
		byte[] bytesEncoded = Base64.encodeBase64(encodingBuffer.getBytes());
		return new String(bytesEncoded);
	}

	private String doDecode(String encoded) {
		byte[] valueDecoded = Base64.decodeBase64(encoded.getBytes());
		String decoded = new String(valueDecoded);
		decoded = this.eliminateEncryptionKey(decoded);
		return decoded;
	}

	public static String encode(String data) {
		return instance.doEncode(data);
	}

	public static String decode(String encoded) {
		return instance.doDecode(encoded);
	}
}
