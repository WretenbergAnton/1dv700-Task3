/**
 * Implements a simple substitution cipher
 * Uses an 8-bit key (0-255) to shift alphabetic characters only
 */
public class SubstitutionCipher {
  public static String encrypt(String text, int key) {
    // Ensure key is within 8-bit range (0-255)
    key = key % 256;

    StringBuilder result = new StringBuilder();

    // Process each character
    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);

      if (Character.isUpperCase(c)) {
        // Shift uppercase letters (A-Z)
        char encrypted = (char) (((c - 'A' + key) % 26) + 'A');
        result.append(encrypted);
      } else if (Character.isLowerCase(c)){
        // Shift lowercase letters (a-z)
        char encrypted = (char) (((c - 'a' + key) % 26) + 'a');
        result.append(encrypted);
      } else {
        // Keep non-alphaetic characters unchanged
        result.append(c);
      }
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

      if (Character.isUpperCase(c)) {
        // Shift uppercase letters back (A-Z)
        char decrypted = (char) (((c - 'A' - key + 26) % 26) + 'A');
        result.append(decrypted);
      } else if (Character.isLowerCase(c)) {
        // Shift uppercase letters back (a-z)
        char decrypted = (char) (((c - 'a' - key +26) % 26) + 'a');
        result.append(decrypted);
      } else {
        // Keep non-alphabetic characters unchanged
        result.append(c);
      }
    }

    return result.toString();
  }
}
