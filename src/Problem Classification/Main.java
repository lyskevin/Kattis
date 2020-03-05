import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        HashMap<String, HashSet<String>> categories = new HashMap<>();
        HashMap<String, Integer> frequencies = new HashMap<>();
        // Map words to their categories
        for (int i = 0; i < n; i++) {
            String category = fio.next();
            int w = fio.nextInt();
            for (int j = 0; j < w; j++) {
                String word = fio.next();
                if (!categories.containsKey(word)) {
                    categories.put(word, new HashSet<>());
                }
                categories.get(word).add(category);
            }
            frequencies.put(category, 0);
        }
        int maxFrequency = 0;
        while (true) {
            try {
                // Count frequency of each category
                String word = fio.next();
                if (categories.containsKey(word)) {
                    for (String category : categories.get(word)) {
                        frequencies.put(category, frequencies.get(category) + 1);
                        maxFrequency = Math.max(maxFrequency, frequencies.get(category));
                    }
                }
            } catch (NullPointerException e) {
                break;
            }
        }
        // Print categories with the highest frequency in lexicographical order
        ArrayList<String> categoryList = new ArrayList<>();
        for (String category : frequencies.keySet()) {
            if (frequencies.get(category).intValue() == maxFrequency) {
                categoryList.add(category);
            }
        }
        Collections.sort(categoryList);
        for (String category : categoryList) {
            fio.println(category);
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

