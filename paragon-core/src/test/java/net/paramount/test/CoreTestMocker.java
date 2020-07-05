//import net.paramount.common.CommonConstants;

/**
 * 
 *//*
package net.paramount.test;

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

import net.paramount.exceptions.CryptographyException;
import net.paramount.framework.security.Cryptographer;
import net.paramount.security.CryptographyAlgorithm;
import net.paramount.security.GlobalCryptogramRepository;
import net.paramount.security.SecretAlgorithm;

*//**
 * @author ducbq
 *
 *//*
public class CoreTestMocker {
	//Z1qh5aEWcgeVyzy5PUBIBbJ3bbygHe/vHemIVM9ekFYI6uSMNoTcJhEQKrvBJYSyaN0Jq6C7NoIPkFqgWUxvNwVwH0wMQILqH5YoW5R0biw=
	static final String encodedMessage = "HBzX4hQOCBp/ifGhU8N997Hq/cB/F/GY6m3bdct9jGWRDL92MzS8DhiT7FGbn4WozZb3UfxuGlQXU5DdCJv2NaWFFTE+aULl6PiConA0BVD9HztB71S+e+5z7f/1O+75mFO7CM75XDNFeXbtpuYOdWqSBXcE0Rko7F34ptLOh/OYQpfInCHhg10Va5woXjJ+ifEpbZ8d8saqzxeh0O+iert4PhTaVp6X/gT5lEuiSlovxTMKhEvDAilsPRb11QZvsRJgBe930E/s6ZveEV/R3IgSwJ8omCNzyHJniz60MRU=";
	static final String message = "Không có dự án nào hoàn thành nếu không có biên bản nghiệm thu tổng thể từ khách hàng. Hầu hết các vấn đề xảy ra đã có kế hoạch giải quyết trong  quản trị rủi ro.";

	*//**
	 * @param args
	 *//*
	public static void main(String[] args) {
		try {
			//mainIv();
			testCryptographer();
			//testDES();
			//testCryptographer();
			//doMain();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected static void testCryptographer() {
		//String originBufffer = "Ví dụ mã hóa, giải mã với DES";
		String encodedBuffer = "PScrh7xOa5eS7YKoQvLmf8e2ih8bVbpUIffYKTx7cIikA8peLu4he08VuclBkoo1";
		String encoded = null, decoded = null;
		try {
			Cryptographer cryptographer = GlobalCryptogramRepository.builder().build().getCryptographer(CryptographyAlgorithm.PLAIN_TEXT);
			
			encoded = cryptographer.stringEncode(message);
			System.out.println("[" + encoded + "]");

			decoded = cryptographer.stringDecode(encoded);
			System.out.println("[" + decoded + "]");
			

			System.out.println("-----------------------------------------------------------------------");
			final String secretKey = "The^' co' na`y thi` Cái gì cũng được";
			cryptographer = GlobalCryptogramRepository.builder().build().getCryptographer(CryptographyAlgorithm.PRIVATE_MEDIUM);
			//encoded = cryptographer.encode(message, secretKey);
			//System.out.println("[" + decoded + "]");

			decoded = cryptographer.decode(encodedMessage, secretKey);
			System.out.println("[" + decoded + "]");
			
			System.out.println("-----------------------------------------------------------------------");
			cryptographer = GlobalCryptogramRepository.builder().build().getCryptographer(CryptographyAlgorithm.PRIVATE_ADVANCED);
			decoded = cryptographer.stringDecode(encodedBuffer);
			System.out.println("[" + decoded + "]");

			encoded = cryptographer.stringEncode(originBufffer);
			System.out.println("[" + encoded + "]");

			decoded = cryptographer.stringDecode(encoded);
			System.out.println("[" + decoded + "]");

			System.out.println("-----------------------------------------------------------------------");
			cryptographer = GlobalCryptogramRepository.builder().build().getCryptographer(CryptographyAlgorithm.PRIVATE_LOW);
			decoded = cryptographer.stringDecode(encodedBuffer);
			System.out.println("[" + decoded + "]");

			encoded = cryptographer.stringEncode(originBufffer);
			System.out.println("[" + encoded + "]");

			System.out.println("-----------------------------------------------------------------------");
			cryptographer = GlobalCryptogramRepository.builder().build().getCryptographer(CryptographyAlgorithm.PRIVATE_MEDIUM);
			encoded = cryptographer.encodeToString(originBufffer);
			System.out.println("[" + encoded + "]");
			decoded = cryptographer.decodeToString(encoded);
			System.out.println("[" + decoded + "]");

			System.out.println("-----------------------------------------------------------------------");
			cryptographer = GlobalCryptogramRepository.builder().build().getCryptographer(CryptographyAlgorithm.PRIVATE_HIGH);
			encoded = cryptographer.encodeToString(originBufffer);
			System.out.println("[" + encoded + "]");
			decoded = cryptographer.decodeToString(encoded);
			System.out.println("[" + decoded + "]");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected static void doMain() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
    String SECRET_KEY = "10293847";
    SecretKeySpec skeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), SecretAlgorithm.DES.name() "DES");
    
    String original = "Ví dụ mã hóa, giải mã với DES";
    
    Cipher cipher = Cipher.getInstance(SecretAlgorithm.DES.getIntance());
    cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
    byte[] byteEncrypted = cipher.doFinal(original.getBytes());
    String encrypted =  Base64.getEncoder().encodeToString(byteEncrypted);
    
    
    cipher.init(Cipher.DECRYPT_MODE, skeySpec);
    byte[] byteDecrypted = cipher.doFinal(encrypted.getBytes("UTF8")byteEncrypted);
    String decrypted = new String(byteDecrypted);
    
    System.out.println("original  text: " + original);
    System.out.println("encrypted text: " + encrypted);
    System.out.println("decrypted text: " + decrypted);
    
  }	
	
  protected static void testDES() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
    String SECRET_KEY = "zaq!@WSX";
    SecretKeySpec skeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "DES");

    String original = "stackjava.com";
    
    Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5PADDING");
    cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
    byte[] byteEncrypted = cipher.doFinal(original.getBytes());
    String encrypted =  Base64.getEncoder().encodeToString(byteEncrypted);
    
    
    cipher.init(Cipher.DECRYPT_MODE, skeySpec);
    byte[] byteDecrypted = cipher.doFinal(byteEncrypted);
    String decrypted = new String(byteDecrypted);
    
    System.out.println("original  text: " + original);
    System.out.println("encrypted text: " + encrypted);
    System.out.println("decrypted text: " + decrypted);
    
  }

  protected static void testUnicorn() throws CryptographyException {
  	Cryptographer cryptographer = GlobalCryptogramRepository.builder().build().getCryptographer(CryptographyAlgorithm.PRIVATE_HIGH);
		String encoded = cryptographer.stringEncode(message);
		System.out.println("[" + encoded + "]");

		String decoded = cryptographer.stringDecode(encoded);
		System.out.println("[" + decoded + "]");
  	
  }
  
	public static void mainIv() throws Exception {

		String text = "kyle boon";

		String codedtext = encodeCipher(text);
		String decodedtext = decodeCipher(codedtext);

		System.out.println(codedtext); // this is a byte array, you'll just see a reference to an array
		System.out.println(decodedtext); // This correctly shows "kyle boon"
	}

	protected static String encodeCipher(String message) throws Exception {
		byte[] encryptedBytes = encrypt(message);
		return encodeBase64(encryptedBytes);
	}

	protected static String decodeCipher(String encodedMessage) throws Exception {
		byte[] encryptedBytes = decodeBase64(encodedMessage);
		return decrypt(encryptedBytes);
	}

	protected static String encodeBase64(byte[] bytes) {
		String encryptedString = new String(Base64.getEncoder().encode(bytes));
		return encryptedString;
	}

	protected static byte[] decodeBase64(String buffer) {
		byte[] decodedBytes = Base64.getDecoder().decode(buffer);
		return decodedBytes;
	}

	protected static byte[] encrypt(String message) throws NoSuchAlgorithmException, UnsupportedEncodingException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		final MessageDigest md = MessageDigest.getInstance("md5");
		final byte[] digestOfPassword = md.digest("HG58YZ3CR9".getBytes("utf-8"));
		final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
		for (int j = 0, k = 16; j < 8;) {
			keyBytes[k++] = keyBytes[j++];
		}

		final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
		final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
		final Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key, iv);

		final byte[] plainTextBytes = message.getBytes("utf-8");
		final byte[] cipherText = cipher.doFinal(plainTextBytes);
		// final String encodedCipherText = new sun.misc.BASE64Encoder()
		// .encode(cipherText);

		return cipherText;
	}

	protected static String decrypt(byte[] message) throws Exception {
		final MessageDigest md = MessageDigest.getInstance("md5");
		final byte[] digestOfPassword = md.digest("HG58YZ3CR9".getBytes("utf-8"));
		final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
		for (int j = 0, k = 16; j < 8;) {
			keyBytes[k++] = keyBytes[j++];
		}

		final SecretKey key = new SecretKeySpec(keyBytes, "DESede");
		final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
		final Cipher decipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
		decipher.init(Cipher.DECRYPT_MODE, key, iv);

		// final byte[] encData = new
		// sun.misc.BASE64Decoder().decodeBuffer(message);
		final byte[] plainText = decipher.doFinal(message);

		return new String(plainText, CommonConstants.ENCODING_NAME_UTF8);
	}
}
*/