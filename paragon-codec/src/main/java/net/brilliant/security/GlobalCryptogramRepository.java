/**
 * 
 */
package net.brilliant.security;

import net.brilliant.security.base.Cryptographer;

/**
 * @author ducbq
 *
 */
public class GlobalCryptogramRepository {
	public static final String SECRET_KEY = "noSecret";

	private GlobalCryptogramRepository() {
	}

	public static GlobalCryptogramRepository getInstance() {
		return SingletonHolder.INSTANCE;		
	}

  private static class SingletonHolder {
    private static final GlobalCryptogramRepository INSTANCE = new GlobalCryptogramRepository();
  }
  
	public Cryptographer getCryptographer(CryptographyAlgorithm algorithm) {
		if (CryptographyAlgorithm.PLAIN_TEXT.equals(algorithm))
			return PlainTextCryptographer.builder().build();

		if (CryptographyAlgorithm.PRIVATE_ADVANCED.equals(algorithm))
			return AdvancedCryptographer.builder().build();

		if (CryptographyAlgorithm.PRIVATE_UNICORN.equals(algorithm))
			return UnicornCryptographer.builder().build();

		if (CryptographyAlgorithm.PRIVATE_HIGH.equals(algorithm))
			return PrivateHighCryptographer.builder().build();
		
		if (CryptographyAlgorithm.PRIVATE_MEDIUM.equals(algorithm))
			return MediumCryptographer.builder().build();

		if (CryptographyAlgorithm.PRIVATE_MEDIUM.equals(algorithm))
			return PrivateLowCryptographer.builder().build();

		return BasicCryptographer.builder().build();
	}

	public Cryptographer getDefaultCryptographer() {
		return this.getCryptographer(CryptographyAlgorithm.PRIVATE_MEDIUM);
	}
}
