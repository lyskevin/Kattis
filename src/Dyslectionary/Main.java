import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

/**
 * @author lyskevin
 */
public class Main {

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        String input = fr.nextLine();
        ArrayList<String> words = new ArrayList<>();
        int maxWordLength = 0;
        while (input != null) {
            if (input.length() == 0) {
                sortAndPrint(words, maxWordLength);
                System.out.println();
                words = new ArrayList<>();
                maxWordLength = 0;
            } else {
                words.add(input);
                maxWordLength = Math.max(maxWordLength, input.length());
            }
            input = fr.nextLine();
        }
        sortAndPrint(words, maxWordLength);
    }

    private static void sortAndPrint(ArrayList<String> words, int maxWordLength) {

        Comparator<String> wordComparator = new Comparator<>() {
            @Override
            public int compare(String word1, String word2) {
                int result = 0;
                int length1 = word1.length();
                int length2 = word2.length();
                for (int i = 0, n = Math.min(length1, length2); i < n; i++) {
                    int difference =
                        word1.charAt(length1 - 1 - i) - word2.charAt(length2 - 1 - i);
                    if (difference != 0) {
                        result = difference;
                        break;
                    }
                }
                if (result == 0) {
                    return word1.length() - word2.length();
                } else {
                    return result;
                }
            }
        };

        Collections.sort(words, wordComparator);
        for (int i = 0, n = words.size(); i < n; i++) {
            System.out.format("%" + maxWordLength + "s\n", words.get(i));
        }

    }

}

/**
 * Fast I/O
 * @source https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
 */
class FastReader 
{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader() 
    { 
        br = new BufferedReader(new
                InputStreamReader(System.in)); 
    } 

    String next() 
    { 
        while (st == null || !st.hasMoreElements()) 
        { 
            try
            { 
                st = new StringTokenizer(br.readLine()); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            }
        } 
        return st.nextToken(); 
    } 

    int nextInt() 
    { 
        return Integer.parseInt(next()); 
    } 

    long nextLong() 
    { 
        return Long.parseLong(next()); 
    } 

    double nextDouble() 
    { 
        return Double.parseDouble(next()); 
    } 

    String nextLine() 
    { 
        String str = ""; 
        try
        { 
            str = br.readLine(); 
        } 
        catch (IOException e) 
        { 
            e.printStackTrace(); 
        } 
        return str; 
    } 
}

