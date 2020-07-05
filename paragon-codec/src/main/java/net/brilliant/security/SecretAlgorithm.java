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
public enum SecretAlgorithm {
	AES("AES/ECB/PKCS5PADDING"),
	DES("DES/ECB/PKCS5PADDING")
	;
	
	private String instance;

	SecretAlgorithm(String instance){
		this.instance = instance;
	}

	public String getIntance() {
		return this.instance;
	}
}
