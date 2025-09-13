import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;

public class FileReading {
    public static void main(String[] args) {
        String filePath = "file.txt";
        HashSet<String> uniqueWords = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    uniqueWords.add(word.toLowerCase());
                }
            }

            System.out.printf("The file has %d unique words \n", uniqueWords.size());
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Something went wrong");
        }
    }
}