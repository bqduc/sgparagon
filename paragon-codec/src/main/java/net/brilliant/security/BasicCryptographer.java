/**
 * 
 */
package net.brilliant.security;

import java.util.Base64;

import lombok.Builder;
import net.brilliant.exceptions.CryptographyException;
import net.brilliant.security.base.Cryptographer;
import net.brilliant.security.base.CryptographyBase;

/**
 * 
 * @author ducbq
 *
 */
@Builder
public class BasicCryptographer extends CryptographyBase implements Cryptographer {
	private static final long serialVersionUID = 2263410453350168100L;

	protected String performStringEncode(String plainText) throws CryptographyException {
		String bufferToBeEncoded = super.addSalts(plainText);
		return Base64.getEncoder().encodeToString(bufferToBeEncoded.getBytes());
	}

	protected String performStringDecode(String encodedBuffer) throws CryptographyException {
		byte[] byteDecoded = Base64.getDecoder().decode(encodedBuffer.getBytes());
		return super.eliminateSalts(new String(byteDecoded));
	}
}
