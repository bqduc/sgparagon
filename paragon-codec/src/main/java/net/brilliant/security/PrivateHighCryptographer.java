/**
 * 
 */
package net.brilliant.security;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

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
public class PrivateHighCryptographer extends CryptographyBase implements Cryptographer {
	private static final long serialVersionUID = 7929328903855470539L;

	private static final String SECRET_KEY = "12345678";

	@Override
	public String stringEncode(String plainText) throws CryptographyException {
		String encodedBuffer = plainText;
		String bufferToBeEncoded = super.addSalts(plainText);

		SecretKeySpec ecretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), SecretAlgorithm.DES.name());
		Cipher cipher;
		try {
			cipher = Cipher.getInstance(SecretAlgorithm.DES.getIntance());

			cipher.init(Cipher.ENCRYPT_MODE, ecretKeySpec);
			byte[] byteEncrypted = cipher.doFinal(bufferToBeEncoded.getBytes());
			encodedBuffer = Base64.getEncoder().encodeToString(byteEncrypted);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException
				| InvalidKeyException e) {
			throw new CryptographyException(e);
		}

		return encodedBuffer;
	}

	@Override
	public String stringDecode(String encodedText) throws CryptographyException {
		String decodedBuffer = encodedText;
		Cipher cipher;
		SecretKeySpec ecretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), SecretAlgorithm.DES.name());
		try {
			cipher = Cipher.getInstance(SecretAlgorithm.DES.getIntance());
	    cipher.init(Cipher.DECRYPT_MODE, ecretKeySpec);
	    byte[] byteDecrypted = cipher.doFinal(encodedText.getBytes());
	    decodedBuffer = new String(byteDecrypted);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
			throw new CryptographyException(e);
		}
		return super.eliminateSalts(decodedBuffer);
	}
}
