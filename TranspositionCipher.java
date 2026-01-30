public class TranspositionCipher {
  
  public static String encrypt(String text, String key) {
    int numColumns = key.length();
    int numRows = (int) Math.ceil((double) text.length() / numColumns);

    // Create a 2D grid to hold the characthers
    char[][] grid = new char[numRows][numColumns];

    // Fill the grid with the text (row by row)
    int index = 0;
    for (int row = 0; row < numRows; row++) {
      for (int col = 0; col < numColumns; col++) {
        if (index < text.length()) {
          grid[row][col] = text.charAt(index);
          index++;
        } else {
          // Pad with spaces if needed
          grid[row][col] = ' ';
        }
      }
    }

    // Read columns in the order specified by the key
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < numColumns; i++) {
      char keyChar = key.charAt(i);
      int colIndex = Character.getNumericValue(keyChar) - 1; // Convert 1 to 0, 2 to 1 etc.

      for (int row = 0; row < numRows; row++) {
        result.append(grid[row][colIndex]);
      }
    }

    return result.toString();
  }

  public static String decrypt(String text, String key) {
    int numColumns = key.length();
    int numRows = text.length() / numColumns;

    // Create a 2D grid to hold the characters
    char[][] grid = new char[numRows][numColumns];

    // Fill the grid column by column in the order specified by the key
    int index = 0;
    for (int i = 0; i < numColumns; i++) {
      char keyChar = key.charAt(i);
      int colIndex = Character.getNumericValue(keyChar) - 1;

      for (int row = 0; row < numRows; row++) {
        if (index < text.length()) {
          grid[row][colIndex] = text.charAt(index);
          index++;
        }
      }
    }

    // Read the grid row by row to get the original text
    StringBuilder result = new StringBuilder();
    for (int row = 0; row < numRows; row++) {
      for (int col = 0; col < numColumns; col++) {
        result.append(grid[row][col]);
      }
    }

    return result.toString();
  }
}
