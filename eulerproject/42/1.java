import java.io.*;
import java.util.*;

public class Mysample {
    public static void main(String[] args) {
        File file = new File("src/p042_words.txt");
        try {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter(",");
            int counter = 0;
            while (scanner.hasNext()) {
                String wordWithColon = scanner.next();
                String word = wordWithColon.substring(1, wordWithColon.length() - 1);
                if (word.length() == 0) {
                    continue;
                }
                int sum = 0;
                int index = 0;
                while (index < word.length()) {
                    sum += word.charAt(index) - 'A' + 1;
                    index++;
                }
                // System.out.println(word);
                int n = (int) Math.floor(Math.sqrt(sum * 2));
                if (n * (n + 1) == sum * 2) {
                    counter++;
                }
            }
            System.out.println(counter);
            scanner.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
