import java.util.*;
import java.math.*;
import java.io.*;

public class Mysample {
    public static void main(String [] args) {
        File file = new File("src/p022_names.txt");
        try {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter(",");
            long order = 1;
            long sum = 0;
            List<String> list = new ArrayList<String>();
            while (scanner.hasNext()) {
                String s = scanner.next();
                list.add(s);
            }
            Collections.sort(list);

            for (int i = 0; i < list.size(); i++) {
                int temp = 0;
                for (int j = 0; j < list.get(i).length(); j++) {
                    if (list.get(i).charAt(j) == '"') {
                        continue;
                    }
                    // System.out.println(list.get(i).charAt(j) - 'A');
                    temp += list.get(i).charAt(j) - 'A' + 1;
                }
                // System.out.println(order + " " + list.get(i) + " " + temp);
                sum += temp * order;
                order++;
            }
            System.out.println(sum);
            scanner.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

// the file is divided using comma
// but double quotes still exist, be careful.
