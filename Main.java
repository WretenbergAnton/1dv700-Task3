
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

    scanner.close();
  }
}