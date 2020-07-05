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
public class PrivateLowCryptographer extends CryptographyBase implements Cryptographer {
	private static final long serialVersionUID = -8881569992005725778L;

	private Cipher cipher;
	private Key key;

	private void init() throws CryptographyException {
		try {
			this.cipher = Cipher.getInstance("AES");
			byte[] raw = { (byte) 0xA5, (byte) 0x01, (byte) 0x7B, (byte) 0xE5, (byte) 0x23, (byte) 0xCA, (byte) 0xD4,
					(byte) 0xD2, (byte) 0xC6, (byte) 0x5F, (byte) 0x7D, (byte) 0x8B, (byte) 0x0B, (byte) 0x9A, (byte) 0x3C,
					(byte) 0xF1 };
			this.key = new SecretKeySpec(raw, "AES");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			throw new CryptographyException (e);
		}
	}

	@Override
	public String stringEncode(String plainText) throws CryptographyException {
		String result = "";
		try {
			if (null == this.cipher) {
				this.init();
			}

			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] utf8 = plainText.getBytes("UTF8");
			byte[] encryptedData = cipher.doFinal(utf8);
			result = new String(utf8, "UTF8");
			result = Base64.getEncoder().encodeToString(encryptedData);
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | IOException e) {
			throw new CryptographyException (e);
		}
		return result;
	}

	@Override
	public String stringDecode(String encodedText) throws CryptographyException {
		String result = "";
		try {
			if (null == this.cipher) {
				this.init();
			}
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decodedData = Base64.getDecoder().decode(encodedText); // com.sun.org.apache.xml.internal.security.utils.Base64.decode(encodedText);//this.b64Decoder.decodeBuffer(aData);
			byte[] utf8 = cipher.doFinal(decodedData);
			result = new String(utf8, "UTF8");
		} catch (InvalidKeyException oException) {
			oException.printStackTrace();
		}
		// catch (Base64DecodingException oException) { oException.printStackTrace(); }
		catch (IllegalBlockSizeException oException) {
			oException.printStackTrace();
		} catch (BadPaddingException oException) {
			oException.printStackTrace();
		} catch (UnsupportedEncodingException oException) {
			oException.printStackTrace();
		}
		return result;
	}
	
	
	
}
