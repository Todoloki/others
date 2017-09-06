import java.io.*;
import java.util.*;
import java.math.*;

public class Mysample {
    public static void main(String[] args) {
        File file = new File("src/p059_cipher.txt");
        try {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter(",");
            List<Character> encrypted = new ArrayList<Character>();
            while (scanner.hasNext()) {
                String s = scanner.next();
                if (s.charAt(s.length() - 1) == '\n') {
                    s = s.substring(0, s.length() - 1);
                }
                // System.out.println(s);
                //System.out.println(Integer.parseInt(s));
                char c = (char) Integer.parseInt(s);
               // System.out.print(c);
                encrypted.add(c);
            }
            for (char a = 'a'; a <= 'z'; a++) {
                for (char b = 'a'; b <= 'z'; b++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        List<Character> key = new ArrayList<Character>();
                        key.add(a);
                        key.add(b);
                        key.add(c);
                        int index = 0;
                        int sum = 0;
                        boolean valid = true;
                        StringBuffer sb = new StringBuffer();
                        while (index < encrypted.size()) {
                            char encrypt = encrypted.get(index);
                            encrypt = (char) (encrypt ^ key.get(index % 3));
                            sb.append(encrypt);

                            if (!(encrypt >= ' ' && encrypt <= '~') || encrypt == '`') {
                                // System.out.println(encrypt);
                                valid = false;
                                break;
                            }
                            sum += encrypt;
                            index++;
                        }
                        if (valid == false) {
                            continue;
                        }
                        System.out.println(sb.toString());
                        System.out.println(sum);
                    }
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
// all graphical characters
// except a character that seems will not appear in common english words
// chose the most meaningful one.
