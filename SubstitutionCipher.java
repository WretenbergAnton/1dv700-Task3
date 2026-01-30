/**
 * Implements a simple substitution cipher
 * Uses an 8-bit key (0-255) to shift characters
 */
public class SubstitutionCipher {
  public static String encrypt(String text, int key) {
    // Ensure key is within 8-bit range (0-255)
    key = key % 256;

    StringBuilder result = new StringBuilder();

    // Process each character
    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);

      // Shift the character by the key value
      char encrypted = (char) ((c + key) % 256);
      result.append(encrypted);
    }

    return result.toString();
  }

  public static String decrypt(String text, int key) {
    // Ensure key is within 8-bit range (0-255)
    key = key % 256;

    StringBuilder result = new StringBuilder();

    // Process each character
    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);

      // shift the characters back by the key value
      char decrypted = (char) ((c - key + 256) % 256);
      result.append(decrypted);
    }

    return result.toString();
  }
}
