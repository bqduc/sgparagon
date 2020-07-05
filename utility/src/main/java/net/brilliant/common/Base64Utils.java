/**
 * 
 */
package net.brilliant.common;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author bqduc
 *
 */
public class Base64Utils {

  public static String encode(String value) {
     return  Base64.getEncoder().encodeToString(value.getBytes(StandardCharsets.UTF_8));
  }

  public static String decode(String value) {
     byte[] decodedValue = Base64.getDecoder().decode(value);  // Basic Base64 decoding
     return new String(decodedValue, StandardCharsets.UTF_8);
  }
}
