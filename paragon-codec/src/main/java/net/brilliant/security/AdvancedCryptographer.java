/**
 * 
 */
package net.brilliant.security;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import lombok.AllArgsConstructor;
import lombok.Builder;
import net.brilliant.common.CommonUtility;
import net.brilliant.exceptions.CryptographyException;
import net.brilliant.security.base.Cryptographer;
import net.brilliant.security.base.CryptographyBase;

/**
 * 
 * @author ducbq
 *
 */
@AllArgsConstructor
@Builder
public class AdvancedCryptographer extends CryptographyBase implements Cryptographer {
	private static final long serialVersionUID = -343502455937920427L;

	private Cipher cipher;
	private Key key;

	private void init() throws CryptographyException {
		try {
			this.cipher = Cipher.getInstance(SecretAlgorithm.AES.name());
			/*byte[] secretKeyRaw = { 
					(byte) 0xA5, (byte) 0x01, (byte) 0x7B, (byte) 0xE5,
					(byte) 0x23, (byte) 0xCA, (byte) 0xD4, (byte) 0xD2,
					(byte) 0xC6, (byte) 0x5F, (byte) 0x7D, (byte) 0x8B,
					(byte) 0x0B, (byte) 0x9A, (byte) 0x3C, (byte) 0xF1 };*/
			this.key = new SecretKeySpec(privateSecretKeyRaw, SecretAlgorithm.AES.name());
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			 throw new CryptographyException(e);
		}
	}

	@Override
	protected String performStringEncode(String plainText) throws CryptographyException {
		String result = CommonUtility.STRING_BLANK;
		try {
			if (null==this.cipher) {
				this.init();
			}

			cipher.init(Cipher.ENCRYPT_MODE, key);
			String buffer = super.addSalts(plainText);
			byte[] utf8Bytes = buffer.getBytes(CommonUtility.ENCODING_UTF8);
			byte[] encryptedData = cipher.doFinal(utf8Bytes);
			result = new String(utf8Bytes, CommonUtility.ENCODING_UTF8);
			result = Base64.getEncoder().encodeToString(encryptedData);
		} catch (InvalidKeyException|IllegalBlockSizeException|BadPaddingException|IOException e) { 					
			throw new CryptographyException(e); 
		}
		return result;
	}

	@Override
	protected String performStringDecode(String encodedBuffer) throws CryptographyException {
		String result = CommonUtility.STRING_BLANK;
		try {
			if (null == this.cipher) {
				this.init();
			}

			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decodedData = Base64.getDecoder().decode(encodedBuffer); 
			byte[] utf8 = cipher.doFinal(decodedData);
			result = new String(utf8, "UTF8");
			result = super.eliminateSalts(result);
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | UnsupportedEncodingException e) {
			throw new CryptographyException(e); 
		}
		return result;
	}
}
