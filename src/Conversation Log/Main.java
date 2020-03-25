import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        HashSet<String> users = new HashSet<>();
        HashMap<String, HashSet<String>> wordsToUsers = new HashMap<>();
        HashMap<String, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] words = fio.nextLine().split(" ");
            users.add(words[0]);
            for (int j = 1; j < words.length; j++) {
                if (!wordsToUsers.containsKey(words[j])) {
                    wordsToUsers.put(words[j], new HashSet<>());
                    frequencies.put(words[j], 0);
                }
                wordsToUsers.get(words[j]).add(words[0]);
                frequencies.put(words[j], frequencies.get(words[j]) + 1);
            }
        }
        ArrayList<Word> keywords = new ArrayList<>();
        for (String word : wordsToUsers.keySet()) {
            if (wordsToUsers.get(word).size() == users.size()) {
                keywords.add(new Word(word, frequencies.get(word)));
            }
        }
        if (keywords.isEmpty()) {
            fio.println("ALL CLEAR");
        } else {
            Collections.sort(keywords);
            for (Word word : keywords) {
                fio.println(word.word);
            }
        }
        fio.close();
    }
}

class Word implements Comparable<Word> {

    String word;
    int frequency;

    Word(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Word other) {
        if (this.frequency != other.frequency) {
            return other.frequency - this.frequency;
        }
        return this.word.compareTo(other.word);
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

