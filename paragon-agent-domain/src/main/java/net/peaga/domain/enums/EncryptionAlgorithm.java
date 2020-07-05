/**
 * 
 */
package net.peaga.domain.enums;

/**
 * @author ducbq
 *
 */
public enum EncryptionAlgorithm {
	PLAN_TEXT("PlanText"),
	PRIVATE_1("Private1");
	
	private String algorithm;
	
	private EncryptionAlgorithm(String algorithm){
		this.setAlgorithm(algorithm);
	}

	public String getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}
}
