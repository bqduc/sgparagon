/**
 * 
 */
package net.brilliant.security;

/**
 * Encryption and decryption algorithm
 * 
 * @author ducbq
 *
 */
public enum CryptographyAlgorithm {
	PLAIN_TEXT("plainText"),
	PRIVATE_LOW("privateLow"),
	PRIVATE_MEDIUM("privateMedium"),
	PRIVATE_HIGH("privateHigh"), 
	PRIVATE_UNICORN("privateUnicorn"), 
	PRIVATE_ADVANCED("privateAdvanced");
	
	private String algorithm;

	CryptographyAlgorithm(String algorithm){
	}

	public String getAlgorithm() {
		return algorithm;
	}
}
