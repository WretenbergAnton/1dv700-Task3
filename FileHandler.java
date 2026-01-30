
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHandler {
  
  public static String readFile(String filename) throws IOException {
    return new String(Files.readAllBytes(Paths.get(filename)));
  }

  public static void writeFile(String filename, String content) throws IOException {
    Files.write(Paths.get(filename), content.getBytes());
  }
}
