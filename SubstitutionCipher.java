import java.util.Random;

/**
 * Implements a simple substitution cipher
 * Uses an 8-bit key (0-255) where each key generates a unique alphabet
 */
public class SubstitutionCipher {
  
  /**
   * Generates a shuffled alphabet based on the key
   * Each key produces a unique, consistent alphabet
   * @param key the encryption key (0-255)
   * @param isUpperCase true for uppercase alphabet, false for lowercase
   * @return a shuffled alphabet as char array
   */
  private static char[] generateAlphabet(int key, boolean isUpperCase) {
    char[] alphabet = new char[26];
    char startChar = isUpperCase ? 'A' : 'a';
    
    // Initialize alphabet with normal order
    for (int i = 0; i < 26; i++) {
      alphabet[i] = (char) (startChar + i);
    }
    
    // Shuffle the alphabet using the key as seed
    Random random = new Random(key);
    for (int i = 25; i > 0; i--) {
      int j = random.nextInt(i + 1);
      // Swap alphabet[i] and alphabet[j]
      char temp = alphabet[i];
      alphabet[i] = alphabet[j];
      alphabet[j] = temp;
    }
    
    return alphabet;
  }
  
  /**
   * Encrypts text using substitution cipher
   * Each key (0-255) creates a unique substitution alphabet
   * @param text the plaintext to encrypt
   * @param key the encryption key (0-255)
   * @return the encrypted text
   */
  public static String encrypt(String text, int key) {
    // Ensure key is within 8-bit range (0-255)
    key = key % 256;
    
    // Generate unique alphabets for this key
    char[] upperAlphabet = generateAlphabet(key, true);
    char[] lowerAlphabet = generateAlphabet(key, false);
    
    StringBuilder result = new StringBuilder();
    
    // Process each character
    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      
      if (Character.isUpperCase(c)) {
        // Substitute using uppercase alphabet
        int position = c - 'A';
        result.append(upperAlphabet[position]);
      } else if (Character.isLowerCase(c)) {
        // Substitute using lowercase alphabet
        int position = c - 'a';
        result.append(lowerAlphabet[position]);
      } else {
        // Keep non-alphabetic characters unchanged
        result.append(c);
      }
    }
    
    return result.toString();
  }
  
  /**
   * Decrypts text using substitution cipher
   * Uses the same key to reverse the substitution
   * @param text the ciphertext to decrypt
   * @param key the decryption key (0-255)
   * @return the decrypted text
   */
  public static String decrypt(String text, int key) {
    // Ensure key is within 8-bit range (0-255)
    key = key % 256;
    
    // Generate the same alphabets used for encryption
    char[] upperAlphabet = generateAlphabet(key, true);
    char[] lowerAlphabet = generateAlphabet(key, false);
    
    StringBuilder result = new StringBuilder();
    
    // Process each character
    for (int i = 0; i < text.length(); i++) {
      char c = text.charAt(i);
      
      if (Character.isUpperCase(c)) {
        // Find the position of this character in the encrypted alphabet
        int position = -1;
        for (int j = 0; j < 26; j++) {
          if (upperAlphabet[j] == c) {
            position = j;
            break;
          }
        }
        // The position tells us the original character
        result.append((char) ('A' + position));
      } else if (Character.isLowerCase(c)) {
        // Find the position of this character in the encrypted alphabet
        int position = -1;
        for (int j = 0; j < 26; j++) {
          if (lowerAlphabet[j] == c) {
            position = j;
            break;
          }
        }
        // The position tells us the original character
        result.append((char) ('a' + position));
      } else {
        // Keep non-alphabetic characters unchanged
        result.append(c);
      }
    }
    
    return result.toString();
  }
}