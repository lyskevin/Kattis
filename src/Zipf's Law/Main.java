import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        String input = fio.nextLine();
        while (true) {
            HashMap<String, Integer> wordCounts = new HashMap<>();
            while (!input.equals("EndOfText")) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < input.length(); i++) {
                    char character = input.charAt(i);
                    if (Character.isLetter(character)) {
                        stringBuilder.append(Character.toLowerCase(character));
                    } else {
                        if (stringBuilder.length() > 0) {
                            String word = stringBuilder.toString();
                            if (wordCounts.containsKey(word)) {
                                wordCounts.put(word, wordCounts.get(word) + 1);
                            } else {
                                wordCounts.put(word, 1);
                            }
                        }
                        stringBuilder = new StringBuilder();
                    }
                }
                if (stringBuilder.length() > 0) {
                    String word = stringBuilder.toString();
                    if (wordCounts.containsKey(word)) {
                        wordCounts.put(word, wordCounts.get(word) + 1);
                    } else {
                        wordCounts.put(word, 1);
                    }
                }
                input = fio.nextLine();
            }
            ArrayList<String> words = new ArrayList<>();
            Set<String> wordSet = wordCounts.keySet();
            for (String word : wordSet) {
                words.add(word);
            }
            Collections.sort(words);
            int count = 0;
            for (int i = 0; i < words.size(); i++) {
                String word = words.get(i);
                if (wordCounts.get(word) == n) {
                    fio.println(word);
                    count++;
                }
            }
            if (count == 0) {
                fio.println("There is no such word.");
            }
            try {
                n = fio.nextInt();
                input = fio.nextLine();
                fio.println();
            } catch (NullPointerException e) {
                break;
            }
        }
        fio.close();
    }
}

/**
 * Fast I/O
 * @source https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
 */
class FastIO extends PrintWriter 
{ 
    BufferedReader br; 
    StringTokenizer st;

    public FastIO() 
    { 
        super(new BufferedOutputStream(System.out)); 
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
            catch (IOException  e) 
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

