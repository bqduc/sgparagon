/**
 * 
 */
package net.brilliant.security;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

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
@Builder
public class MediumCryptographer extends CryptographyBase implements Cryptographer {

	protected String performStringEncode(String plainText) throws CryptographyException {
		String bufferToBeEncoded = super.addSalts(plainText);
		return Base64.getEncoder().encodeToString(bufferToBeEncoded.getBytes());
	}

	protected String performStringDecode(String encodedBuffer) throws CryptographyException {
		byte[] byteDecoded = Base64.getDecoder().decode(encodedBuffer.getBytes());
		return super.eliminateSalts(new String(byteDecoded));
	}

	private static SecretKeySpec secretKey;
	private static byte[] key;

	private void setKey(String myKey) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		key = myKey.getBytes(CommonUtility.ENCODING_NAME_UTF8);
		MessageDigest sha = MessageDigest.getInstance("SHA-1");
		key = sha.digest(key);
		key = Arrays.copyOf(key, 16);
		secretKey = new SecretKeySpec(key, SecretAlgorithm.AES.name());
	}

	private String encrypt(String strToEncrypt, String secret)
			throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException {
		setKey(secret);
		Cipher cipher = Cipher.getInstance(SecretAlgorithm.AES.getIntance());
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		return Base64.getEncoder()
				.encodeToString(cipher.doFinal(strToEncrypt.getBytes(CommonUtility.ENCODING_NAME_UTF8)));
	}

	private String decrypt(String strToDecrypt, String secret) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
			setKey(secret);
			Cipher cipher = Cipher.getInstance(SecretAlgorithm.AES.getIntance());
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
	}
	/*
	public static void main(String[] args) {
		final String secretKey = "Cái gì cũng được";

		String originalString = "Phong ba bão táp, Không có gì phức tạp bằng ngữ pháp và hành xử ở Việt Nam";
		
		MediumCryptographer mediumCryptographer = MediumCryptographer.builder().build();
		String encryptedString = null;
		try {
			encryptedString = mediumCryptographer.encrypt(originalString, secretKey);
		} catch (InvalidKeyException | UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException
				| IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		String decryptedString = null;
		try {
			decryptedString = mediumCryptographer.decrypt(encryptedString, secretKey);
		} catch (InvalidKeyException | UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException
				| IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(originalString); System.out.println(encryptedString);
		System.out.println(decryptedString);
	}
	*/

	@Override
	protected String doEncode(String message, String secretKey) throws CryptographyException {
		try {
			return this.encrypt(message, secretKey);
		} catch (InvalidKeyException | UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException
				| IllegalBlockSizeException | BadPaddingException e) {
			throw new CryptographyException (e);
		}
	}

	@Override
	protected String doDecode(String message, String secretKey) throws CryptographyException {
		try {
			return this.decrypt(message, secretKey);
		} catch (InvalidKeyException | UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException
				| IllegalBlockSizeException | BadPaddingException e) {
			throw new CryptographyException (e);
		}
	}
}
