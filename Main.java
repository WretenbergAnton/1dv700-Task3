
import java.io.IOException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Ask user for encryption or decryption
    System.out.print("Do you want to encrypt (E) or decrypt (D)? ");
    String choice = scanner.nextLine().trim().toUpperCase();

    // Validate input
    while (!choice.equals("E") && !choice.equals("D")) {
      System.out.print("Invalid choice. Please enter E or D");
      choice = scanner.nextLine().trim().toUpperCase();
    }

    // Ask user for cipher method
    System.out.print("Do you want to use substitution (S) or transposition (T)? ");
    String method = scanner.nextLine().trim().toUpperCase();

    // Validate input
    while (!method.equals("S") && !method.equals("T")) {
      System.out.print("Invalid choice. Please enter S or T: ");
      method = scanner.nextLine().trim().toUpperCase();
    }

    // Ask user for secret key
    System.out.print("Input the secret key: ");
    String key = scanner.nextLine().trim();

    // Validate that key is not empty
    while (key.isEmpty()) {
      System.out.print("Key cannot be empty. Please enter a key: ");
      key = scanner.nextLine().trim();
    }

    // Ask user for filename
    System.out.print("Input the name of the file you want to process: ");
    String filename = scanner.nextLine().trim();

    // Validate that filename is not empty
    while (filename.isEmpty()) {
      System.out.print("Filename cannot be empty. Please enter a filenaem: ");
      filename = scanner.nextLine().trim();
    }

    // Read the file
    String content;
    try {
      content = FileHandler.readFile(filename);
    } catch (IOException e) {
      System.out.println("Error: Could not read file '" + filename + "'");
      System.out.println("Please make sure the file exists and try again.");
      scanner.close();
      return;
    }

    // Process the content based on the method and choice
    String result;

    if (method.equals("S")) {
      // Substitution cipher - convert key to integer
      int keyValue = Integer.parseInt(key);

      if (choice.equals("E")) {
        result = SubstitutionCipher.encrypt(content, keyValue);
      } else {
        result = SubstitutionCipher.decrypt(content, keyValue);
      }
    } else {
      // Transposition cipher
      if (choice.equals("E")) {
        result = TranspositionCipher.encrpyts(content, key);
      } else {
        result = TranspositionCipher.decrypt(content, key);
      }
    }

    // Generate output filename
    String outputFilename;
    if (choice.equals("E")) {
      outputFilename = filename.replace(".txt", "_enc.txt");
    } else {
      outputFilename = filename.replace(".txt", "_dec.txt");
    }

    // Write result to file
    try {
      FileHandler.writeFile(outputFilename, result);
      System.out.println("The file has been " + (choice.equals("E") ? "encrypted" : "decrypted") + " and the results have been saved in the file " + outputFilename);
    } catch (IOException e) {
      System.out.println("Error: Could not write to file '" + outputFilename + "'");
    }
    scanner.close();
  }
}
