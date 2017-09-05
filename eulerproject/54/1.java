import java.io.*;
import java.util.*;
import java.math.*;

public class Mysample {
    public static void main(String[] args) {
        File file = new File("src/p054_poker.txt");
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("2", 0);
        map.put("3", 1);
        map.put("4", 2);
        map.put("5", 3);
        map.put("6", 4);
        map.put("7", 5);
        map.put("8", 6);
        map.put("9", 7);
        map.put("T", 8);
        map.put("J", 9);
        map.put("Q", 10);
        map.put("K", 11);
        map.put("A", 12);

        int counter = 0;
        try {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("\\s+");
            while (scanner.hasNext()) {
                int c = 0;
                List<String> curHands = new ArrayList<String>();
                while (scanner.hasNext() && c < 10) {
                    String s = scanner.next();
                    // System.out.print(s + " ");
                    curHands.add(s);
                    c++;
                }
                // System.out.println("");
                // System.out.println(curHands.size());
                if (curHands.size() < 10) {
                    break;
                }
                int[] values1 = new int[13];

                int rank1 = getRank(curHands, 0, 4, map);
                int rank2 = getRank(curHands, 5, 9, map);
                if (rank1 < rank2) {
                    counter++;
                }
                else if (rank1 == rank2) {
                    if (isLarger(curHands, rank1, map)) {
                        counter++;
                    }
                }
            }
            System.out.println(counter);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static int getRank(List<String> curHands, int start, int end, HashMap<String, Integer> map) {
        int[] counter = new int[13];
        boolean isSameSuit = true;
        char targetSuit = curHands.get(start).charAt(curHands.get(start).length() - 1);
        for (int i = start; i <= end; i++) {
            String card = curHands.get(i);
            String value = card.substring(0, card.length() - 1);
            char suit = card.charAt(card.length() - 1);
            if (suit != targetSuit) {
                isSameSuit = false;
            }
            if (map.containsKey(value) == false) {
                System.out.println(value + " " + "wrong");
            }
            counter[map.get(value)]++;
        }

        // if it is a royal flush
        // return 0;

        // in same suit
        if (isSameSuit) {
            // contains ten, jack, queen, king, ace
            if (counter[map.get("T")] == 1 && counter[map.get("J")] == 1 && counter[map.get("Q")] == 1 && counter[map.get("K")] == 1 && counter[map.get("A")] == 1) {
                return 0;
            }
        }

        // if it is a straight flush
        // return 1;

        // in same suit
        if (isSameSuit) {
            // find consecutive values
            for (int i = 0; i < counter.length - 5 + 1; i++) {
                if (counter[i] == 1 && counter[i + 1] == 1 && counter[i + 2] == 1 && counter[i + 3] == 1 && counter[i + 4] == 1) {
                    return 1;
                }
            }
        }

        // if it is four of a kind
        // return 2;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == 4) {
                return 2;
            }
        }

        // if it is four house
        // return 3;
        boolean find3 = false;
        boolean find2 = false;

        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == 2) {
                find2 = true;
            }
            if (counter[i] == 3) {
                find3 = true;
            }
        }
        if (find2 && find3) {
            return 3;
        }

        // if it is flush
        // return 4;
        if (isSameSuit) {
            return 4;
        }

        // if it is straight
        // return 5;
        for (int i = 0; i < counter.length - 5 + 1; i++) {
            if (counter[i] == 1 && counter[i + 1] == 1 && counter[i + 2] == 1 && counter[i + 3] == 1 && counter[i + 4] == 1) {
                return 5;
            }
        }

        // if it is three of a kind
        // return 6;
        if (find3) {
            return 6;
        }

        // if it is two pairs
        // return 7
        int counterOfPairs = 0;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == 2) {
                counterOfPairs++;
            }
        }
        if (counterOfPairs == 2) {
            return 7;
        }

        // if it is two pairs
        // return 8
        if (find2) {
            return 8;
        }

        // high card
        return 9;
    }

    public static boolean isLarger(List<String> curHands, int level, HashMap<String, Integer> map) {
        int[] counter1 = new int[13];
        int[] counter2 = new int[13];

        for (int i = 0; i < 5; i++) {
            String value = curHands.get(i).substring(0, curHands.get(i).length() - 1);
            counter1[map.get(value)]++;
        }
        for (int i = 5; i < 10; i++) {
            String value = curHands.get(i).substring(0, curHands.get(i).length() - 1);
            counter2[map.get(value)]++;
        }

        if (level == 0) {
            return true;
        }

        if (level == 1) {
            for (int i = 12; i >= 0; i--) {
                if (counter1[i] > counter2[i]) {
                    return true;
                }
                else if (counter2[i] > counter1[i]) {
                    return false;
                }
            }
            return true;
        }

        if (level == 2) {
            int value1 = -1;
            int value2 = -1;
            for (int i = 0; i < counter1.length; i++) {
                if (counter1[i] == 4) {
                    value1 = i;
                }
            }
            for (int i = 0; i < counter2.length; i++) {
                if (counter2[i] == 4) {
                    value2 = i;
                }
            }
            if (value1 > value2) {
                return true;
            }
            else if (value1 < value2) {
                return false;
            }
            counter1[value1] = 0;
            counter2[value2] = 0;

            for (int i = 12; i >= 0; i--) {
                if (counter1[i] > counter2[i]) {
                    return true;
                }
                else if (counter1[i] < counter2[i]) {
                    return false;
                }
            }
            return true;
        }

        if (level == 3) {
            int value31 = -1;
            int value32 = -1;
            int value21 = -1;
            int value22 = -1;
            for (int i = 0; i < counter1.length; i++) {
                if (counter1[i] == 2) {
                    value21 = i;
                }
                if (counter1[i] == 3) {
                    value31 = i;
                }
            }
            for (int i = 0; i < counter2.length; i++) {
                if (counter2[i] == 2) {
                    value22 = i;
                }
                if (counter2[i] == 3) {
                    value32 = i;
                }
            }
            if (value31 > value32) {
                return true;
            }
            else if (value31 < value32) {
                return false;
            }
            if (value21 > value22) {
                return true;
            }
            else if (value21 < value22) {
                return false;
            }
            counter1[value31] = 0;
            counter1[value21] = 0;
            counter2[value32] = 0;
            counter2[value22] = 0;
            for (int i = 12; i >= 0; i--) {
                if (counter1[i] > counter2[i]) {
                    return true;
                }
                else if (counter1[i] < counter2[i]) {
                    return false;
                }
            }
            return true;
        }
        if (level == 4) {
            // flush
            for (int i = 12; i >= 0; i--) {
                if (counter1[i] > counter2[i]) {
                    return true;
                }
                else if (counter1[i] < counter2[i]) {
                    return false;
                }
            }
            return true;
        }
        if (level == 5) {
            // straight
            for (int i = 12; i >= 0; i--) {
                if (counter1[i] > counter2[i]) {
                    return true;
                }
                else if (counter1[i] < counter2[i]) {
                    return false;
                }
            }
            return true;
        }
        if (level == 6) {
            // three of a kind
            int value31 = -1;
            int value32 = -1;
            for (int i = 0; i < counter1.length; i++) {
                if (counter1[i] == 3) {
                    value31 = i;
                }
            }
            for (int i = 0; i < counter2.length; i++) {
                if (counter2[i] == 3) {
                    value32 = i;
                }
            }
            if (value31 > value32) {
                return true;
            }
            else if (value31 < value32){
                return false;
            }
            counter1[value31] = 0;
            counter2[value32] = 0;
            for (int i = 12; i >= 0; i--) {
                if (counter1[i] > counter2[i]) {
                    return true;
                }
                else if (counter1[i] < counter2[i]) {
                    return false;
                }
            }
            return true;
        }

        if (level == 7) {
            // two pairs

            int index11 = -1;
            int index12 = -1;
            int index21 = -1;
            int index22 = -1;

            for (int i = 0; i < counter1.length; i++) {
                if (counter1[i] == 2) {
                    if (index11 != -1) {
                        index12 = i;
                    }
                    else {
                        index11 = i;
                    }
                }
            }
            for (int i = 0; i < counter2.length; i++) {
                if (counter2[i] == 2) {
                    if (index21 != -1) {
                        index22 = i;
                    }
                    else {
                        index21 = i;
                    }
                }
            }

            if (index12 > index22) {
                return true;
            }
            else if (index12 < index22) {
                return false;
            }
            if (index11 > index12) {
                return true;
            }
            else if (index11 < index12) {
                return false;
            }
            counter1[index11] = 0;
            counter1[index12] = 0;
            counter2[index21] = 0;
            counter2[index22] = 0;
            for (int i = 12; i >= 0; i--) {
                if (counter1[i] > counter2[i]) {
                    return true;
                }
                else if (counter1[i] < counter2[i]) {
                    return false;
                }
            }
            return true;
        }
        if (level == 8) {
            // pairs

            int index11 = -1;
            int index12 = -1;

            for (int i = 0; i < counter1.length; i++) {
                if (counter1[i] == 2) {
                    index11 = i;
                }
            }
            for (int i = 0; i < counter2.length; i++) {
                if (counter2[i] == 2) {
                    index12 = i;
                }
            }
            if (index11 > index12) {
                return true;
            }
            else if (index11 < index12) {
                return false;
            }
            counter1[index11] = 0;
            counter1[index12] = 0;
            for (int i = 12; i >= 0; i--) {
                if (counter1[i] > counter2[i]) {
                    return true;
                }
                else if (counter1[i] < counter2[i]) {
                    return false;
                }
            }
            return true;
        }
        for (int i = 12; i >= 0; i--) {
            if (counter1[i] > counter2[i]) {
                return true;
            }
            else if (counter1[i] < counter2[i]) {
                return false;
            }
        }
        return true;
    }
}
