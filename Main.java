
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

    System.out.println("You selected: " + (choice.equals("E") ? "Encrypt" : "Decrypt"));

    // Ask user for cipher method
    System.out.print("Do you want to use substitution (S) or transposition (T)? ");
    String method = scanner.nextLine().trim().toUpperCase();

    // Validate input
    while (!method.equals("S") && !method.equals("T")) {
      System.out.print("Invalid choice. Please enter S or T: ");
      method = scanner.nextLine().trim().toUpperCase();
    }

    System.out.println("You selected: " + (method.equals("S") ? "Substitution" : "Transposition"));

    // Ask user for secret key
    System.out.print("Input the secret key: ");
    String key = scanner.nextLine().trim();

    // Validate that key is not empty
    while (key.isEmpty()) {
      System.out.print("Key cannot be empty. Please enter a key: ");
      key = scanner.nextLine().trim();
    }

    System.out.println("Key received: " + key);

    scanner.close();
  }
}