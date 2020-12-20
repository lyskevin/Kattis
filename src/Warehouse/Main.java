import java.io.*;
import java.util.*;

/**
 * @author lyskevin
 */
public class Main {
    public static void main(String[] args) {
        FastIO fio = new FastIO();

        int T = fio.nextInt();
        for (int i = 0; i < T; i++) {
            int N = fio.nextInt();
            HashMap<String, Integer> toys = new HashMap<>();
            
            for (int j = 0; j < N; j++) {
                String toy = fio.next();
                int count = fio.nextInt();

                if (!toys.containsKey(toy)) {
                    toys.put(toy, 0);
                }
                
                toys.put(toy, toys.get(toy) + count);
            }

            int total = toys.size();

            TreeMap<Integer, TreeSet<String>> results = new TreeMap<>(Comparator.reverseOrder());

            for (String toy : toys.keySet()) {
                int count = toys.get(toy);

                if (!results.containsKey(count)) {
                    results.put(count, new TreeSet<>());
                }

                results.get(count).add(toy);
            }

            fio.println(total);
            for (int count : results.keySet()) {
                for (String toy : results.get(count)) {
                    fio.println(toy + " " + count);
                }
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

