/**
 * 
 */
package net.brilliant.security;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import lombok.Builder;
import net.brilliant.common.CommonConstants;
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
public class UnicornCryptographer extends CryptographyBase implements Cryptographer {
	private static final long serialVersionUID = -4992452627197880398L;

	/*private static Cipher encryptCipher;
	private static Cipher decryptCipher;*/
	//private static final String desKey = "0123456789abcdef0123456789abcdef0123456789abcdef"; // value from user
	private static final String encodingCharset = CommonConstants.ENCODING_NAME_UTF8;
	private static final String digestBuffer = "0987654321HG58YZ3CR91029384756";//"HG58YZ3CR9";
	private static final String transformationName = "DESede/CBC/PKCS5Padding";
	private static final String messageDigestAlgorithm = "MD5";
	private static final String secretKeyAlgorithm = "DESede";

	private static final int LOW_STEPS = 8;
	private static final int HIGH_STEPS = 16;
	/*
	public static void main(String[] args) throws Exception {
		try {
			String buffer = "Không có cái con khỉ dọc gì";
			String desKey = "0123456789abcdef0123456789abcdef0123456789abcdef"; // value from user
			byte[] keyBytes = DatatypeConverter.parseHexBinary(desKey);
			System.out.println((int) keyBytes.length);

			SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");
			SecretKey key = factory.generateSecret(new DESedeKeySpec(keyBytes));

			encryptCipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
			encryptCipher.init(Cipher.ENCRYPT_MODE, key); // throwing Exception
			byte[] encryptedData = encryptData(buffer);

			decryptCipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");

			byte iv[] = encryptCipher.getIV(); 
			IvParameterSpec dps = new IvParameterSpec(iv);
			decryptCipher.init(Cipher.DECRYPT_MODE, key, dps);			
			
			//decryptCipher.init(Cipher.DECRYPT_MODE, key);
			decryptData(encryptedData);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
	}

	private void init() throws InvalidKeyException, InvalidKeySpecException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException {
		byte[] keyBytes = DatatypeConverter.parseHexBinary(desKey);
		System.out.println((int) keyBytes.length);

		SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");
		SecretKey key = factory.generateSecret(new DESedeKeySpec(keyBytes));

		encryptCipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
		encryptCipher.init(Cipher.ENCRYPT_MODE, key); // throwing Exception

		decryptCipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");

		byte iv[] = encryptCipher.getIV(); 
		IvParameterSpec dps = new IvParameterSpec(iv);
		decryptCipher.init(Cipher.DECRYPT_MODE, key, dps);			
	}

	private byte[] encryptData(String data) throws IllegalBlockSizeException, BadPaddingException {
		byte[] dataToEncrypt = data.getBytes();
		byte[] encryptedData = encryptCipher.doFinal(dataToEncrypt);
		return encryptedData;
	}

	private byte[] decryptData(byte[] data) throws IllegalBlockSizeException, BadPaddingException {
		byte[] decryptedData = decryptCipher.doFinal(data);
		return decryptedData;
	}
	*/

	@Override
	protected String performStringEncode(String plainText) throws CryptographyException {
		return this.encodeMessage(plainText);
	}

	@Override
	protected String performStringDecode(String encodedBuffer) throws CryptographyException {
		return this.decodeMessage(encodedBuffer);
	}
	
	private String encodeMessage(String message) throws CryptographyException {
		String encodedMessage = CommonUtility.STRING_BLANK;
		byte[] encryptedBytes = null;
		try {
			encryptedBytes = encrypt(message);
			encodedMessage = encodeBase64(encryptedBytes);
		} catch (InvalidKeyException | NoSuchAlgorithmException | UnsupportedEncodingException | NoSuchPaddingException
				| InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
			throw new CryptographyException(e);
		}
		return encodedMessage;
	}

	private String decodeMessage(String encodedMessage) throws CryptographyException {
		String decodedMessage = CommonUtility.STRING_BLANK;
		byte[] encryptedBytes = null;
		try {
			encryptedBytes = decodeBase64(encodedMessage);
			decodedMessage = decrypt(encryptedBytes);
		} catch (InvalidKeyException | NoSuchAlgorithmException | UnsupportedEncodingException | NoSuchPaddingException
				| InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
			throw new CryptographyException(e);
		}
		return decodedMessage;
	}

	private String encodeBase64(byte[] bytes) {
		String encryptedString = new String(Base64.getEncoder().encode(bytes));
		return encryptedString;
	}

	protected byte[] decodeBase64(String buffer) {
		byte[] decodedBytes = Base64.getDecoder().decode(buffer);
		return decodedBytes;
	}

	protected byte[] encrypt(String message) throws NoSuchAlgorithmException, UnsupportedEncodingException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		final MessageDigest md = MessageDigest.getInstance(messageDigestAlgorithm);
		final byte[] digestOfPassword = md.digest(digestBuffer.getBytes(encodingCharset));
		final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
		for (int j = 0, k = HIGH_STEPS; j < LOW_STEPS;) {
			keyBytes[k++] = keyBytes[j++];
		}

		final SecretKey key = new SecretKeySpec(keyBytes, secretKeyAlgorithm);
		final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
		final Cipher cipher = Cipher.getInstance(transformationName);
		cipher.init(Cipher.ENCRYPT_MODE, key, iv);

		final byte[] plainTextBytes = message.getBytes(encodingCharset);
		final byte[] cipherText = cipher.doFinal(plainTextBytes);

		return cipherText;
	}

	protected String decrypt(byte[] message) throws NoSuchAlgorithmException, UnsupportedEncodingException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		final MessageDigest md = MessageDigest.getInstance(messageDigestAlgorithm);
		final byte[] digestOfPassword = md.digest(digestBuffer.getBytes(encodingCharset));
		final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
		for (int j = 0, k = HIGH_STEPS; j < LOW_STEPS;) {
			keyBytes[k++] = keyBytes[j++];
		}

		final SecretKey key = new SecretKeySpec(keyBytes, secretKeyAlgorithm);
		final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
		final Cipher decipher = Cipher.getInstance(transformationName);
		decipher.init(Cipher.DECRYPT_MODE, key, iv);

		final byte[] plainText = decipher.doFinal(message);

		return new String(plainText, encodingCharset);
	}

	@Override
	public byte[] encode(String message) throws CryptographyException {
		byte[] encodedBuffer = null;
		try {
			encodedBuffer = this.encrypt(message);
		} catch (Exception e) {
			throw new CryptographyException(e);
		}
		return encodedBuffer;
	}
}